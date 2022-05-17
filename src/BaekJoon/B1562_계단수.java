package BaekJoon;

import java.util.Scanner;

public class B1562_계단수 {

    static final int MOD=1000000000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        long [][][] dp=new long[N+1][10][1024];

        for(int i=1;i<10;++i){
            dp[1][i][1<<i]=1;
        }

        for(int n=2;n<=N;++n){
            for(int k=0;k<10;++k){
                for(int visit=0;visit<1024;visit++){
                    int newVisit= visit | (1<<k);

                    if(k==0) dp[n][k][newVisit]+=dp[n-1][k+1][visit]%MOD;
                    else if(k==9) dp[n][k][newVisit]+=dp[n-1][k-1][visit]%MOD;
                    else {
                        dp[n][k][newVisit]+=(dp[n-1][k-1][visit]+dp[n-1][k+1][visit])%MOD;
                    }

                    dp[n][k][newVisit]%=MOD;
                }
            }
        }

        long sum=0;
        for(int i=0;i<10;++i){
            sum+=dp[N][i][1023]%MOD;
            sum%=MOD;
        }

        System.out.println(sum);
    }
}
