package BaekJoon;

import java.util.Scanner;

public class B2616_소형기관차 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] train=new int [n+1];
        int [] sum=new int [n+1];
        int [][] dp=new int [4][n+1];

        for(int i=1;i<=n;++i){
            train[i]=sc.nextInt();
            sum[i]=sum[i-1]+train[i];
        }

        int max=sc.nextInt();

        for(int i=1;i<4;++i){
            for(int j=i*max;j<=n;++j){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j-max]+sum[j]-sum[j-max]);
            }
        }

        System.out.println(dp[3][n]);
    }
}
