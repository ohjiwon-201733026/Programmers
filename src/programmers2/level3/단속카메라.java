package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 단속카메라 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(new int [][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }

    public int solution(int [][] routes){
        int answer=0;
        Arrays.sort(routes,(r1,r2)->r1[1]-r2[1]);
        int min=Integer.MIN_VALUE;
        for (int[] route : routes) {
            if(route[0]>min){
                min=route[1];
                answer++;
            }
        }

        return answer;

    }
}
