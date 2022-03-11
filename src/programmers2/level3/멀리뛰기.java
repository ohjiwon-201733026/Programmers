package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 멀리뛰기 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(4));
        Assertions.assertEquals(3,solution(3));
    }

    public int solution(int n){
        int [] dp=new int [n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;++i){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n];
    }
}
