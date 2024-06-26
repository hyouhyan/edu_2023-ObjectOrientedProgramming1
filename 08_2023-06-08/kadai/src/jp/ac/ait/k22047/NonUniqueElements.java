package jp.ac.ait.k22047;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class NonUniqueElements implements IKadai07_4{
    @Override
    public void convert(List<Integer> targetList) {
//        for (Integer number: targetList) {
//            int count = 0;
//            for (Integer i: targetList) if (i.equals(number)) count++;
//
//            if (count == 1) targetList.remove(number);
//        }

        Iterator<Integer> its = targetList.iterator();
        while(its.hasNext()) {
            Integer num = its.next();
            int count = 0;
            for(Integer i: targetList) if(i.equals(num)) count++;

            if(count == 1) its.remove();
        }

    }

    public static void main(String[] args) {
//        NonUniqueElements app = new NonUniqueElements();
//
//        List<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(3);list.add(1);list.add(3);
//        app.convert(list);
//
//        System.out.println(list);
    }
}
