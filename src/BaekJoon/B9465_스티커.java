package BaekJoon;

import java.util.Scanner;

public class B9465_스티커 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while (tc-->0){
            int n=sc.nextInt();
            int [][] arr=new int [2][n];
            int [][] dp=new int [2][n];

            for(int i=0;i<2;++i){
                for(int j=0;j<n;++j){
                    arr[i][j]=sc.nextInt();
                }
            }

            dp[0][0]=arr[0][0];
            dp[1][0]=arr[1][0];
            if(n>=2){
                dp[0][1]=dp[1][0]+arr[0][1];
                dp[1][1]=dp[0][0]+arr[1][1];
            }

            for(int i=2;i<n;++i){
                dp[0][i]=Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i];
                dp[1][i]=Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i];
            }

            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));

        }
    }
}
