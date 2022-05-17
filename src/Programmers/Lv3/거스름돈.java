package Programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 거스름돈 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(5,new int []{1,2,5}));
    }

    public int solution(int n, int[] money) {
        final int MOD=1000000007;
        int [][] dp=new int[money.length][n+1];
        for(int i=0;i<=n;i+=money[0]){
//            if(i%money[0]==0)
                dp[0][i]=1;
        }


        for(int i=1;i<money.length;++i){ // 100
            for(int j=0;j<=n;++j){ // 100,000

                dp[i][j]=dp[i-1][j]%MOD;

                if(j-money[i]>=0) dp[i][j]+=dp[i][j-money[i]]%MOD;

                dp[i][j]%=MOD;
            }
        }

        return dp[money.length-1][n]%MOD;
    }
}
