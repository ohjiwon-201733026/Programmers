package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1890_점프 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] arr= new int [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j]=sc.nextInt();
            }
        }

        long [][] dp=new long [n][n];
        dp[0][0]=1;
        loop:
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i==n-1 && j==n-1) break loop;
                int x=i+arr[i][j];
                int y=j+arr[i][j];
                if(0<=x && x<n) dp[x][j]+=dp[i][j];
                if(0<=y && y<n) dp[i][y]+=dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}