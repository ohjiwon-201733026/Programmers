package Programmers.Lv2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {
    public static void main(String[] args) {
        int [] A={1,4,2};
        int [] B={5,4,4};
        System.out.println(solution(A,B));
    }
    // 1*5 + 4*4 + 2*4 = 29
    // [1,2] [3,4] -> 1*4 + 2*3 =10
    public static int solution(int [] A, int [] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int n=A.length;
        int answer=0;
        for(int i=0;i<n;++i){
            answer+= A[i]*B[n-1-i];
        }

        return answer;

    }
}
