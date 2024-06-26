package jp.ac.ait.k22047;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasswordManager {
    public static boolean validate(String password) throws PasswordRulesViolationException{
        Set<String> unusableStringSet = new HashSet<>(Arrays.asList(
                "password", "p@ssw0rd", "p@55w0rd", "qwerty", "asdfgh", "zxcvbn", "abcdef", "123456"));
        List<Character> symbolList = Arrays.asList(',', '.', '+', '-', '*', '/', '=', '_', '#', '!', '?', '@', ' ');

        boolean rtn;
        //パスワードは16文字以上128文字以下とする
        if(password.length() >= 16 && password.length() <= 128) rtn = true;
        else throw new PasswordRulesViolationException("パスワードは16文字以上128文字以下でなければなりません");

        //パスワードにはアルファベットと数字と一部の記号が使用できる
        //パスワードには必ず、大文字のアルファベット、小文字のアルファベット、数字、記号のうちそれぞれ一文字以上使用されること
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSymbol = false;
        for(char i: password.toCharArray()){
            if(Character.isUpperCase(i)) hasUpper = true;
            else if(Character.isLowerCase(i)) hasLower = true;
            else if(Character.isDigit(i)) hasDigit = true;
            else if(symbolList.contains(i)) hasSymbol = true;
            else throw new PasswordRulesViolationException("パスワードにはアルファベットと数字と一部の記号（,,.,+,-,*,/,=,_,#,!,?,@,（半角スペース））のみ利用することができます");
        }
        if(!(hasDigit && hasLower && hasSymbol && hasUpper)) {
            throw new PasswordRulesViolationException("パスワードには必ず、大文字のアルファベット、小文字のアルファベット、数字、記号のうちそれぞれ一文字以上使用しなければなりません");
        }

        //容易に推測される文字列を「含む」事はできない
        for(String i: unusableStringSet) if(password.contains(i)) {
            throw new PasswordRulesViolationException("容易に推測される文字列を含む事はできません");
        }

        return true;
    }
}
