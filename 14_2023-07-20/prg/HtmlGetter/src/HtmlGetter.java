import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

public class HtmlGetter extends JFrame{
    private JPanel panel1;
    private JTextField httpTextField;
    private JButton get;
    private JButton save;
    private JTextArea htmlContent;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new HtmlGetter().setVisible(true);
        });
    }

    public HtmlGetter(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        setContentPane(panel1);

        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                URL url = null;
                try {
                    url = new URL(httpTextField.getText());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(
                            panel1,
                            "URLの形式が間違っています",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                HttpURLConnection http;
                try {
                    http = (HttpURLConnection) url.openConnection();
                    http.setRequestMethod("GET");
                    http.connect();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            panel1,
                            "サーバーに接続できませんでした",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                StringBuilder res = new StringBuilder();
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(http.getInputStream())))
                {
                    String line;
                    while ((line = in.readLine()) != null) {
                        res.append(line).append("\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            panel1,
                            "サーバーに接続できませんでした",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                htmlContent.setText(String.valueOf(res));

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextFileActionPerformed(e);
            }
        });
    }

    private void saveTextFileActionPerformed(ActionEvent e){
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));

        File f = null;

        // ダイアログを開き、戻り値を取得
        int selected = jfc.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                f = jfc.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default: // case JFileChooser.ERROR_OPTION: でも良い
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
                break;
        }

        if (f != null) {

            // 書き込み対象をBufferedWriterで開く
            try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), Charset.defaultCharset())) {
                // テキスト領域から文字列を読み込み(Scannerを使用するパターン)
                Scanner sc = new Scanner(htmlContent.getText());
                while (sc.hasNextLine()) {
                    bw.append(sc.nextLine());
                    bw.newLine();
                }
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
            }
        }
    }
}
