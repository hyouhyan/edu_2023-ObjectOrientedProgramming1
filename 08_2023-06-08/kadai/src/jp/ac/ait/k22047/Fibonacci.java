package jp.ac.ait.k22047;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci implements IKadai07_1{
    @Override
    public List<Integer> get(int max_value) {
        List<Integer> fiboList = new ArrayList<>();

        if(max_value < 0) return fiboList;

        fiboList.add(0);
        if(max_value == 0) return fiboList;

        fiboList.add(1);
        fiboList.add(1);
        if(max_value == 1) return fiboList;

        while(true){
            int tmpFibo = fiboList.get(fiboList.size() - 1) + fiboList.get(fiboList.size() - 2);
            if (!(tmpFibo > max_value)) fiboList.add(tmpFibo);
            else break;
        }

        return fiboList;
    }

    public static void main(String[] args) {
//        Fibonacci app = new Fibonacci();
//
//        System.out.println(app.get(-1));
//        System.out.println(app.get(0));
//        System.out.println(app.get(1));
//        System.out.println(app.get(10000));
    }
}
