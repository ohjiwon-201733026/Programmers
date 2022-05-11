package BaekJoon;

import java.util.Scanner;

public class B1328_고층빌딩 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int L=sc.nextInt();
        int R=sc.nextInt();
        final int MOD=1000000007;
        long [][][] dp=new long[101][101][101];

        dp[1][1][1]=1;
        dp[2][2][1]=dp[2][1][2]=1;

        for(int n=3;n<=N;++n){
            for(int l=1;l<=L;l++){
                for(int r=1;r<=R;++r){
                    dp[n][l][r]+=dp[n-1][l-1][r]%MOD;
                    dp[n][l][r]+=dp[n-1][l][r-1]%MOD;
                    dp[n][l][r]+=(dp[n-1][l][r]*(n-2))%MOD;
                    dp[n][l][r]%=MOD;
                }
            }
        }
        System.out.println(dp[N][L][R]%MOD);
    }
}
