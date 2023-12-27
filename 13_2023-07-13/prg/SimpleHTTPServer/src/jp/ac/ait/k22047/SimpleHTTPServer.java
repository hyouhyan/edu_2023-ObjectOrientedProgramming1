package jp.ac.ait.k22047;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleHTTPServer extends Thread {
    java.net.Socket socket;

    public SimpleHTTPServer(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        String html;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
            String requests = in.readLine();
            String[] request = requests.split(" ", -1);

            if (request[0].equals("GET") && request[1].equals("/")) {
                try (BufferedReader br = Files.newBufferedReader(Paths.get("./www/index.html"))) {
                    String line;
                    out.println("HTTP/1.0 200 OK");
                    out.println("Content-Type: text/html");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            } else if (request[0].equals("GET")) {
                String[] path;

                try {
                    path = request[1].split("\\.", -1);
                } catch (Exception e) {
                    path = null;
                }

                if (path[1].equals("css")) {
                    try (BufferedReader br = Files.newBufferedReader(Paths.get("www/" + request[1]))) {
                        String line;
                        out.println("HTTP/1.0 200 OK");
                        out.println("Content-Type: text/css");
                        out.println("");
                        while ((line = br.readLine()) != null) {
                            out.println(line);
                        }
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                } else if (path[1].equals("js")) {
                    try (BufferedReader br = Files.newBufferedReader(Paths.get("www/" + request[1]))) {
                        String line;
                        out.println("HTTP/1.0 200 OK");
                        out.println("Content-Type: text/javascript");
                        out.println("");
                        while ((line = br.readLine()) != null) {
                            out.println(line);
                        }
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
            }
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {

        try (ServerSocket ss = new ServerSocket(8088)) {
            while (true) {
                Socket s = ss.accept();
                System.out.printf("接続: %s:%d\n", s.getInetAddress(), s.getPort());
                SimpleHTTPServer app = new SimpleHTTPServer(s);
                app.start();
            }
        }
    }
}
