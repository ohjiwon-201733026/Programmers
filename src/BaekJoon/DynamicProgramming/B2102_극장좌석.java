package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2102_극장좌석 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean [] vip=new boolean[n+1];
        long [] dp=new long[n+1];

        while (m-->0){
            int v=sc.nextInt();
            vip[v]=true;
        }

        dp[0]=dp[1]=1;

        for(int i=2;i<=n;++i){
            if(vip[i]) dp[i]+=dp[i-1];
            else{
                dp[i]+=dp[i-1];
                if(!vip[i-1]) dp[i]+=dp[i-2];
            }
        }

        System.out.println(dp[n]);
    }
}
