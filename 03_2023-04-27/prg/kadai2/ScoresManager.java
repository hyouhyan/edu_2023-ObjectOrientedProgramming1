import java.util.Scanner;

public class ScoresManager {
    static Score score1 = new Score();

    public static void main(String[] args) {
        System.out.println("出席番号を入力してください ");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        int num = Integer.parseInt(inputLine);

        score1.id = num;

        System.out.println("氏名を入力してください ");
        inputLine = in.nextLine();
        score1.name = inputLine;


        System.out.println("国語の点数を入力してください ");
        inputLine = in.nextLine();
        num = Integer.parseInt(inputLine);
        score1.setJapanese(num);

        System.out.println("数学の点数を入力してください ");
        inputLine = in.nextLine();
        num = Integer.parseInt(inputLine);
        score1.setMathmatics(num);

        System.out.println("理科の点数を入力してください ");
        inputLine = in.nextLine();
        num = Integer.parseInt(inputLine);
        score1.setScience(num);

        System.out.println("社会の点数を入力してください ");
        inputLine = in.nextLine();
        num = Integer.parseInt(inputLine);
        score1.setSocialStudies(num);

        System.out.println("英語の点数を入力してください ");
        inputLine = in.nextLine();
        num = Integer.parseInt(inputLine);
        score1.setEnglish(num);

        in.close();

        score1.printInfo();

        return;
    }
}
