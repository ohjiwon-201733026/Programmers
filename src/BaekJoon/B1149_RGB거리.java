package BaekJoon;

import java.util.Scanner;

public class B1149_RGB거리 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] arr=new int [n][3];
        int [][] dp=new int [n][3];

        for(int i=0;i<n;++i){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            arr[i][2]=sc.nextInt();
        }

        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];

        for(int i=1;i<n;++i){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
        }
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<3;++i){
            answer=Math.min(answer,dp[n-1][i]);
        }

        System.out.println(answer);
    }
}
