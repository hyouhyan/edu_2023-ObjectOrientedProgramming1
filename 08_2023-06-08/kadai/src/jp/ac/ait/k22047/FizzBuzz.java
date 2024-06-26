package jp.ac.ait.k22047;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FizzBuzz implements IKadai07_2{
    @Override
    public List<String> getConverted(List<Integer> targetList) {
        List<String> rtList = new ArrayList<>();

        for(Integer i: targetList){
            if(i % 3 == 0 && i % 5 == 0) rtList.add("FizzBuzz");
            else if(i % 3 == 0) rtList.add("Fizz");
            else if(i % 5 == 0) rtList.add("Buzz");
            else rtList.add(String.valueOf(i));
        }
        return rtList;
    }

    public static void main(String[] args) {
//        FizzBuzz app = new FizzBuzz();
//
//        List<Integer> list = new ArrayList<>();
//        for(int i = 1; i <= 100; i++) list.add(i);
//
//        System.out.println(app.getConverted(list));
    }
}
