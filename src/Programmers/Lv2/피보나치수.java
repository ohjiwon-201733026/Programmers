package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 피보나치수 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(3));
        Assertions.assertEquals(5,solution(5));
    }
    static int [] dp;
    public int solution(int n) {
        dp=new int [n+1];

        recur(n);

        return dp[n];

    }

    private int recur(int n){

        if(n==0) return dp[n]=0;
        if(n==1) return dp[n]=1;

        if(dp[n]!=0) return dp[n];

        return dp[n]=(recur(n-1)+recur(n-2))%1234567;

    }
}
