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
        Arrays.sort(A);
        Arrays.sort(B);

        int i=0,j=0;
        int answer=0;
        while(i<A.length){
            if(j>=B.length) break;

            while (true){
                System.out.println(i+" "+j);
                if(j>=B.length) break;
                if(A[i]<B[j]) {
                    answer++;
                    break;
                }
                else j++;
            }
            i++;
            j++;

        }
        return answer;

    }
}
