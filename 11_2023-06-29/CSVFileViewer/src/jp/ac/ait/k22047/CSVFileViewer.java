package jp.ac.ait.k22047;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileViewer {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("csvファイルのパスを入力してください");
        String filePath = sc.nextLine();

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("ファイルが読み込めませんでした");
            System.exit(1);
        }

        String[] cols;
        int count = 0;
        for (String line : lines) {
            count++;
            cols = line.split(",", -1);
            System.out.print(count + ":\t");
            for(int i = 0; i < cols.length; i++) {
                System.out.print((i + 1) + ":" + cols[i]);
                if(i + 1 != cols.length) System.out.print("\t");
            }
            System.out.println();
        }

    }
}
