package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 가장큰수 {

    @Test
    public void test(){
        Assertions.assertEquals("6210",solution(new int []{6, 10, 2}));
        Assertions.assertEquals("9534330",solution(new int []{3, 30, 34, 5, 9}));
    }

    public String solution(int [] numbers){

        ArrayList<String> list=new ArrayList<>();
        for (int number : numbers) {
            list.add(number+"");
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return String.valueOf(o2+o1).compareTo(String.valueOf(o1+o2));
            }
        });
        if(list.get(0).equals("0")) return "0";
        StringBuilder sb=new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
