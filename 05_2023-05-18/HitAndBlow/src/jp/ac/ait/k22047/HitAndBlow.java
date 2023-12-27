package jp.ac.ait.k22047;
import java.util.Scanner;

public class HitAndBlow {
    public static void main(String[] args) {
        Manager app = new Manager();
//        System.out.println(app.getAnswer().get()); //デバッグ用

        Scanner in = new Scanner(System.in);
        Response response;
        while(true) {
            System.out.print("input " + Answer.DIGITS + " numbers: ");
            String inputLine = in.nextLine();

            // 例外判定
            if (!StringUtilities.isUnsignedInteger(inputLine)) {
                System.out.println("エラー！符号なし整数値を入力してください！！");
                System.exit(1);
            }
            if (inputLine.length() != Answer.DIGITS) {
                System.out.println("エラー！文字数が" + Answer.DIGITS + "ではありません！！");
                System.exit(1);
            }

            // 判定するとこ
            response = app.solve(inputLine);
            if(response.getHit() == Answer.DIGITS) break;
            else System.out.println(response.getHit() + "ヒット、" + response.getBlow() + "ブロー");
        }

        System.out.println("正解!すっげー！！");
        System.out.println("試行回数: " + app.getCount());
    }
}
