package BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B7579_앱 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] mem=new int [n];
        int [] cost=new int [n];

        for(int i=0;i<n;++i) mem[i]=sc.nextInt();
        for(int i=0;i<n;++i) cost[i]=sc.nextInt();

        int [][] dp=new int [n][100001];

        for(int i=0;i<n;++i){
            int memory=mem[i];
            int c=cost[i];
            if(i==0){
                dp[i][c]=memory;
                continue;
            }
            for(int j=0;j<=100000;++j){
                dp[i][j]=dp[i-1][j];
                if(j-c>=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-c]+memory);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=100000;++i){
            if(dp[n-1][i]>=m) {
                System.out.println(i);
                break;
            }
        }


    }
}
