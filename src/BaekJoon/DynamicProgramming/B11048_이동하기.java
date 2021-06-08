package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11048_이동하기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] arr=new int[n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=sc.nextInt();
            }
        }

        int [][] dp=new int [n][m];
        dp[0][0]=arr[0][0];
        for(int i=1;i<n;++i){
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        for(int i=1;i<m;++i){
            dp[0][i]=dp[0][i-1]+arr[0][i];
        }

        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]))+arr[i][j];
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}
