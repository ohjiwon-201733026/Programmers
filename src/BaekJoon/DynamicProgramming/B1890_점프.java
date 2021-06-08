package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B1890_점프 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] map=new int [n][n];
        long [][] dp=new long [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                map[i][j]=sc.nextInt();
            }
        }
        dp[0][0]=1;
        loop:
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i==n-1&&j==n-1)  break loop;
                int x=i+map[i][j];
                int y=j+map[i][j];
                if(0<=x && x<n) dp[x][j]+=dp[i][j];
                if(0<=y && y<n) dp[i][y]+=dp[i][j];
            }
        }

        for(int i=0;i<n;++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[n-1][n-1]);



    }



}
