package jp.ac.ait.k22047;

import java.util.ArrayList;
import java.util.List;

public class UniqueString implements IKadai07_3{
    @Override
    public List<String> getUniqueList(List<String> targetList) {
        List<String> rtList = new ArrayList<>();

        for(String i: targetList){
            int count = 0;
            for(String j: targetList) if(j.equals(i)) count++;

            if(count == 1) rtList.add(i);
        }

        return rtList;
    }

    public static void main(String[] args) {
//        UniqueString app = new UniqueString();
//        List<String> list = new ArrayList<>();
//
//        list.add("A");list.add("B");list.add("B");list.add("B");list.add("C");
//
//        System.out.println(app.getUniqueList(list));
    }
}
