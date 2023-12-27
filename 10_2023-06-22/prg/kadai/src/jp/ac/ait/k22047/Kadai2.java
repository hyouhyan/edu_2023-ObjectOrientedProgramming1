package jp.ac.ait.k22047;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kadai2 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        List<String> passList = new ArrayList<>();
//        passList.add("a");
//        passList.add("aaaaaaaaaaaaaaaaaaaa");
//        passList.add("Aaaaaaaaaaaaaaaaaaaa");
//        passList.add("Aaaaaaaaaaaaaaaaaaa1");
//        passList.add("Aaaaaaaaaaaaaaaaaa1@");
//        passList.add("passwordoahdiouadiuhA@a");
//        passList.add("p@ssw0rdoahdiouadiuhA@a");
//        passList.add("p@55w0rdoahdiouadiuA@ha");
//        passList.add("oahdioua123456diuA@ha");
//        passList.add("SuperSecureP@SS123");
//
//

        System.out.println("パスワードを入力してください");
        String pass = sc.nextLine();


        try {
            System.out.println("Password: "+pass);
            PasswordManager.validate(pass);
            System.out.println("OK");
        } catch (PasswordRulesViolationException e) {
            System.out.printf("パスワードのルール基準を満たしていません\n%s\n\n", e.getMessage());
        }



    }
}
