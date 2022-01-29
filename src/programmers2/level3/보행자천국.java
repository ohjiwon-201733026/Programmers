package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 보행자천국 {

    @Test
    public void est() {
        Assertions.assertEquals(6, solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        Assertions.assertEquals(2, solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }

    public int solution(int m, int n, int[][] city_map) {
        int [][][] dp=new int [m][n][2];
        final int MOD=20170805;
        dp[0][0][0]=dp[0][0][1]=1;
        
        for(int i=1;i<m;++i){ // 위
            if(city_map[i][0]!=1) dp[i][0][0]=dp[i-1][0][0];
        }
        for(int i=1;i<n;++i){ // 왼
            if(city_map[0][i]!=1) dp[0][i][1]=dp[0][i-1][1]; 
        }

        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(city_map[i-1][j]!=1){
                    if(city_map[i-1][j]==2) dp[i][j][0]=dp[i-1][j][0];
                    else dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1])%MOD;
                }
                if(city_map[i][j-1]!=1){
                    if(city_map[i][j-1]==2) dp[i][j][1]=dp[i][j-1][1];
                    else dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1])%MOD;
                }
            }
        }

        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
        
    }
}
