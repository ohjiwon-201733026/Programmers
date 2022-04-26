package BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B7579_앱 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int M=sc.nextInt();
        int ans=Integer.MAX_VALUE;
        int [] m=new int [n];
        int [] c=new int [n];
        int [][] dp=new int [n][100001];
        for(int i=0;i<n;++i) m[i]=sc.nextInt();
        for(int i=0;i<n;++i) c[i]=sc.nextInt();

        for(int i=0;i<n;++i){
            int cost=c[i];
            int memory=m[i];

            for(int j=0;j<=10000;++j){
                if(i==0){
                    if(j>=cost) dp[i][j]=memory;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                    if(j>=cost) dp[i][j]=Math.max(dp[i-1][j-cost]+memory,dp[i-1][j]);
                }

                if(dp[i][j]>=M) ans=Math.min(ans,j);
            }
        }
        System.out.println(ans);
    }
}
