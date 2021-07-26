package Programmers.Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    public static void main(String[] args) {
        int [] numbers={6, 10, 2};
        String answer=solution(numbers);
        System.out.println(answer);

    }

    public static String solution(int [] numbers){
        String answer= "";

        String []str_numbers=new String[numbers.length];

        for(int i=0;i<numbers.length;++i){
            str_numbers[i]=numbers[i]+"";
        }

        Arrays.sort(str_numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(str_numbers[0].startsWith("0")) return "0";
        else{
            for(int j=0;j< str_numbers.length;++j){
                answer+=str_numbers[j];
            }
        }

        return answer;
    }
}
