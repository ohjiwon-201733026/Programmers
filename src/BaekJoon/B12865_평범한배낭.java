package BaekJoon;

import java.util.Scanner;

public class B12865_평범한배낭 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int [] w=new int [n+1];
        int [] v=new int [n+1];

        int [][] dp=new int [n+1][k+1];
        for(int i=1;i<=n;++i) {
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }

        for(int i=1;i<=n;++i){
            for(int j=1;j<=k;++j){
                dp[i][j]=dp[i-1][j];
                if(0<=j-w[i]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        int answer=0;
        for(int i=0;i<=k;++i){
            answer=Math.max(answer,dp[n][i]);
        }

        System.out.println(answer);

    }

}
