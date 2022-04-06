package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1890_점프 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int [][] map=new int [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                map[i][j]=sc.nextInt();
            }
        }

        long [][] dp=new long [n][n];
        dp[0][0]=1;
        loop:
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i==n-1&& j==n-1) break loop;
                int nextI=i+map[i][j];
                int nextJ=j+map[i][j];
                if(0<=nextI && nextI<n){
                    dp[nextI][j]+=dp[i][j];
                }
                if(0<=nextJ && nextJ<n){
                    dp[i][nextJ]+=dp[i][j];
                }
            }
        }



        System.out.println(dp[n-1][n-1]);
    }
}