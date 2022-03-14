package BaekJoon;

import java.util.Scanner;

public class B1932_정수삼각형 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] arr=new int [n][n];
        int [][] dp=new int [n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<i+1;++j){
                arr[i][j]=sc.nextInt();
            }
        }

        dp[0][0]=arr[0][0];
        for(int i=1;i<n;++i){
            dp[i][0]=dp[i-1][0]+arr[i][0];
            dp[i][i]=dp[i-1][i-1]+arr[i][i];
        }

        for(int i=2;i<n;++i){
            for(int j=1;j<i;++j){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }


        int answer=0;
        for(int i=0;i<n;++i){
            answer=Math.max(dp[n-1][i],answer);
        }
        System.out.println(answer);
    }
}
