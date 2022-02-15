package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숫자게임 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(new int []{5,1,3,7},new int []{2,2,6,8}));
        Assertions.assertEquals(0,solution(new int []{2,2,2,2},new int []{1,1,1,1}));
    }

    public int solution(int [] A, int [] B){
        PriorityQueue<Integer> q=new PriorityQueue<>();
        Arrays.sort(A);
        int i=0;
        int j=0;
        for(i=0;i<A.length;++i){
            int a=A[i];
            int b=B[j];
            while (true) {
                if (a > b) j++;
                else break;
                if(j>B.length) break;
                b=B[j];
            }
            if(j>B.length) break;

        }

        return i;

    }
}
