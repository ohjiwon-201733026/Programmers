package BaekJoon;

import java.util.Scanner;

public class B1915_가장큰정사각형 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        int [][] arr=new int [N+1][M+1];
        int [][] dp=new int [N+1][M+1];

        for(int i=1;i<=N;++i){
            String s=sc.next();
            for(int j=1;j<=M;++j){
                arr[i][j]=s.charAt(j-1)-'0';
            }
        }

        int answer=0;
        for(int i=1;i<=N;++i){
            for(int j=1;j<=M;++j){
                if(arr[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+arr[i][j];
                    answer=Math.max(answer,dp[i][j]);
                }
            }
        }

        System.out.println(answer*answer);


    }
}
