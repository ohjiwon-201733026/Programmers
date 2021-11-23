package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class 숫자게임 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(new int []{5,1,3,7}, new int [] {2,2,6,8}));
        Assertions.assertEquals(0,solution(new int []{2,2,2,2}, new int [] {1,1,1,1}));
        Assertions.assertEquals(1,solution(new int []{5,5,6,8}, new int [] {3,3,7,1}));
    }

    public int solution(int [] A, int [] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int a=0,b=0;
        int score=0;
        while(a<A.length){
            if(A[a]<B[b]){
                score++;
                a++;
            }
            b++;

            if(b>=B.length) break;
        }
        return score;
    }
}
