package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 등굣길 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(4,3,new int [][]{{2,2}}));
    }

    public int solution(int m, int n, int [][] puddles){
        final int mod= 1000000007;
        int [][] dp=new int [m+1][n+1];
        int [][] map=new int [m+1][n+1];
        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]]=1;
        }

        map[1][1]=dp[1][1]=1;
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(map[i][j]==1) continue;
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])% mod;
            }
        }

        return dp[m][n];
    }
}
