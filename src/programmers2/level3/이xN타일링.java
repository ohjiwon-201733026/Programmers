package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 이xN타일링 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(4));
    }

    public int solution(int n){
        int [] dp=new int [n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;++i)
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;

        return dp[n]%1000000007;

    }
}
