package BaekJoon;

import java.util.Scanner;

public class B1149_RGB거리 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] arr=new int [N][3];

        for(int i=0;i<N;++i){
            int R=sc.nextInt();
            int G=sc.nextInt();
            int B=sc.nextInt();
            arr[i][0]=R;arr[i][1]=G;arr[i][2]=B;
        }

        int [][] dp=new int [N][3];
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];

        for(int i=1;i<N;++i){
            for(int j=0;j<3;++j){
                if(j==0){
                    dp[i][j]=arr[i][j]+Math.min(dp[i-1][1],dp[i-1][2]);
                }
                if(j==1){
                    dp[i][j]=arr[i][j]+Math.min(dp[i-1][0],dp[i-1][2]);
                }
                if(j==2){
                    dp[i][j]=arr[i][j]+Math.min(dp[i-1][0],dp[i-1][1]);
                }
            }
        }
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<3;++i){
            answer=Math.min(answer,dp[N-1][i]);
        }

        System.out.println(answer);
    }
}
