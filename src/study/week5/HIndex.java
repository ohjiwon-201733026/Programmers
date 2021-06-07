package study.week5;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    // i   0 1 2 3 4
//   cit   0 1 3 5 6
//포함개수   5 4 3 2 1  cit.length-i
    
    public static void main(String[] args) {
        int [] citations={3, 0, 6, 1, 5};
        int answer=solution(citations);
        System.out.println(answer);
    }


    private static int solution(int[] citations) {
        Arrays.sort(citations);
        int ans=0;
        for(int i=citations.length-1;i>=0;--i){
            if(citations.length-i<=citations[i]) {
                ans= citations.length-i;
            }
        }
        return ans;
    }

}



