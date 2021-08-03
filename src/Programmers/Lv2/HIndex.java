package Programmers.Lv2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {

    public static void main(String[] args) {
        int [] citations={3,0,6,1,5};
        System.out.println(solution(citations));
    }

    public static int solution(int [] citations){
        Arrays.sort(citations);
        int answer=0;
        for(int i=citations.length-1;i>=0;--i){
            if(citations[i]>=citations.length-i) { answer=citations.length-i; }
        }

        return answer;
    }
}
