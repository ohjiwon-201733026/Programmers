package BaekJoon;

import java.util.Scanner;

public class B5557_1학년 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int [n+1];
        long [][] dp=new long [n+1][21];

        for(int i=1;i<=n;++i) arr[i]=sc.nextInt();
        dp[1][arr[1]]=1;
        for(int i=2;i<n;++i){
            for(int j=0;j<=20;++j){
                if(j-arr[i]>=0) dp[i][j]+=dp[i-1][j-arr[i]];
                if(j+arr[i]<=20) dp[i][j]+=dp[i-1][j+arr[i]];
            }
        }

        System.out.println(dp[n-1][arr[n]]);

    }
}
