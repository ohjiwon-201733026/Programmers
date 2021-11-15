package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    @Test
    public void test(){
        Assertions.assertEquals("6210",solution(new int []{6,10,2}));
        Assertions.assertEquals("9534330",solution(new int []{3,30,34,5,9}));
    }

    public String solution(int [] numbers){

        String [] strArr=new String [numbers.length];
        for (int i=0;i< numbers.length;++i) {
            strArr[i]=numbers[i]+"";
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String answer="";
        if(strArr[0].equals("0")) return "0";
        else{
            for(int i=0;i< strArr.length;++i){
                answer+=strArr[i];
            }
        }

        return answer;
    }
}
