package BaekJoon;

import java.util.Scanner;

public class B1328_고층빌딩 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();

        long [][][] dp=new long [101][101][101];

        dp[1][1][1]=1;
        dp[2][2][1]=dp[2][1][2]=1;

        for(int i=3;i<=n;++i){
            for(int j=1;j<=l;++j){
                for(int k=1;k<=r;++k){
                    dp[i][j][k]+=dp[i-1][j-1][k]%1000000007;
                    dp[i][j][k]+=dp[i-1][j][k-1]%1000000007;
                    dp[i][j][k]+=(dp[i-1][j][k]*(i-2))%1000000007;
                }
            }
        }

        System.out.println(dp[n][l][r]%1000000007);
    }
}
