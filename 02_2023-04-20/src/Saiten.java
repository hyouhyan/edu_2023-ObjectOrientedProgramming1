import java.util.Scanner;

public class Saiten {
    public static void main(String[] args) {
        System.out.println("テストの点数を入力してください。");

        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        in.close();

        int point = Integer.parseInt(inputLine);

        if(point >= 60) System.out.println("合格です。おめでとう！");
        else if(point >= 20) System.out.println("不合格です。再テストを行いましょう！");
        else System.out.println("不合格です。来年もう一年頑張りましょう。");

        return;
    }
}
