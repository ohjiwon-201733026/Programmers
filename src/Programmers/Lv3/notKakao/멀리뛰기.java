package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 멀리뛰기 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(4));
//        Assertions.assertEquals(3,solution(3));
    }

    public int solution(int n){
        int [] dp=new int [n+1];

        dp[1]=1;
        if(n>=2){
            dp[2]=2;

            for(int i=3;i<=n;++i){
                dp[i]=dp[i-1]+dp[i-2];
            }
        }


        return dp[n];
    }
}
