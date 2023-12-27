import java.util.Scanner;

public class AtodashiJanken {
    public static void main(String[] args) {
        int randomNumber = new java.util.Random().nextInt(3);

        System.out.print("コンピュータは");
        if(randomNumber == 0) System.out.print("グー");
        else if(randomNumber == 1) System.out.print("チョキ");
        else if(randomNumber == 2) System.out.print("パー");
        System.out.println("を出します。");

        System.out.println("あなたは何を出しますか？ (0:グー,1:チョキ,2:パー)");

        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        in.close();

        int point = Integer.parseInt(inputLine);

        if(point == randomNumber) System.out.println("あいこ");
        else if(point == 0){
            if(randomNumber == 1) System.out.println("勝ち");
            if(randomNumber == 2) System.out.println("負け");
        }else if(point == 1){
            if(randomNumber == 0) System.out.println("負け");
            if(randomNumber == 2) System.out.println("勝ち");
        }else if(point == 2){
            if(randomNumber == 0) System.out.println("勝ち");
            if(randomNumber == 1) System.out.println("負け");
        }else System.out.println("あなたの出した手が判断できません。勝負はしません。");

        return;
    }
}
