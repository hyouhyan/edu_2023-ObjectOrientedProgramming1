import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CSVFileConverter {
    public static void main(String[] args) {

        String filepath = "personal_information.csv";

        // 読み込んだCSVデータの格納先
        List<PersonalInfo> data = new ArrayList<>();

        try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of(filepath)))) {
            // 先頭の行は列タイトルなので読み込んで捨てる
            if (sc.hasNextLine()) sc.nextLine();
            int row = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                row += 1;
                // System.out.println(row + "行目のデータを処理中");

                PersonalInfo pi = new PersonalInfo();
                int col = 0;

                String[] st = line.split(",", -1);

                for (String cell: st) {
                    col += 1; // 列番号インクリメント
                    switch (col) {
                        case 1 -> pi.setName(cell);
                        case 2 -> pi.setNameKana(cell);
                        case 3 -> pi.setMailAddress(cell);
                        case 4 -> pi.setZipCode(cell);
                        case 5 -> pi.setAddress1(cell);
                        case 6 -> pi.setAddress2(cell);
                        case 7 -> pi.setAddress3(cell);
                        case 8 -> pi.setAddress4(cell);
                        case 9 -> pi.setAddress5(cell);
                        case 10 -> pi.setAge(Integer.parseInt(cell));
                        case 11 -> pi.setBloodType(cell);
                    }
                }
                // CSV1行分のデータを格納
                data.add(pi);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        // CSVファイルの変換結果を出力しつつ、出力用のファイルのデータを生成する
        StringBuilder outputData = new StringBuilder("氏名,住所,年齢,血液型");
        outputData.append(System.lineSeparator());
        data.forEach((pi) -> {
            String line = pi.getName() + "(" + pi.getNameKana() + "), ";
            System.out.print("氏名:" + pi.getName() + "(" + pi.getNameKana() + ")");
            line += pi.getZipCode() + " " + pi.getAddress1() + pi.getAddress2() + pi.getAddress3() + pi.getAddress4() + pi.getAddress5() + ", ";
            System.out.print(", 住所:" + pi.getZipCode() + " " + pi.getAddress1() + pi.getAddress2() + pi.getAddress3() + pi.getAddress4() + pi.getAddress5());
            line += pi.getAge() + ", ";
            System.out.print(", 年齢:" + pi.getAge());
            line += pi.getBloodType();
            System.out.print(", 血液型:" + pi.getBloodType());
            System.out.println();

            outputData.append(line);
            outputData.append(System.lineSeparator());
        });

        // ファイル書き込み
        try {
            Files.writeString(Path.of("output.tsv"), outputData.toString());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
