package Programmers.Lv2;

public class 보행자천국 {

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int [][] city_map={{0,0,0},
                {0, 0, 0},{0, 0, 0}};
        System.out.println(solution(m,n,city_map));
    }

    public static int solution(int m, int n, int [][] cityMap){
        int [][][] dp=new int [m][n][2];
        int MOD = 20170805;
        dp[0][0][0]=dp[0][0][1]=1;

        for(int i = 1; i < m; i++){
            if(cityMap[i][0] != 1) dp[i][0][0] = dp[i-1][0][0];
        }
        for(int i = 1; i < n; i++){
            if(cityMap[0][i] != 1) dp[0][i][1] = dp[0][i-1][1];
        }

        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(cityMap[i-1][j]!=1){ // 왼쪽
                    if(cityMap[i-1][j]==2) dp[i][j][0]=dp[i-1][j][0];
                    else dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1])%MOD;
                }

                if(cityMap[i][j-1]!=1){ // 위쪽
                    if(cityMap[i][j-1]==2) dp[i][j][1]=dp[i][j-1][1];
                    else dp[i][j][1]=(dp[i][j-1][0] + dp[i][j-1][1])%MOD;
                }
            }
        }
        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
    }
}
