package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 정수삼각형 {

    @Test
    public void test(){
        Assertions.assertEquals(30, solution(new int [][]{
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        }));
    }

    /**
     * 7
     * 10 15
     * 18 16 15
     * 2 7 4 4
     * 4 5 2 6 5
     */

    public int solution(int [][] triangle){
        int n=triangle.length;

        int [][] dp=new int [n][n];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<n;++i){
            dp[i][0]=triangle[i][0]+dp[i-1][0];
            dp[i][i]=triangle[i][i]+dp[i-1][i-1];
        }

        for(int i=2;i<n;++i){
            for(int j=1;j<i;++j){
                dp[i][j]=triangle[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int answer=0;
        for(int i=0;i<n;++i){
            answer=Math.max(answer,dp[n-1][i]);
        }

        return answer;
    }
}
