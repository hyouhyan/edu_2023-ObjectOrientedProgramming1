import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        System.out.println("整数を入力してください");

        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        in.close();

        int num = Integer.parseInt(inputLine);

        boolean sosu = true;
        for(int i = 2; i < num; i++) if(num % i == 0) sosu = false;

        if(num < 2) sosu = false;

        if(sosu) System.out.println("素数です");
        else System.out.println("素数ではありません");

    }
}
