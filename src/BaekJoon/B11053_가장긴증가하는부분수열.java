package BaekJoon;

import java.util.Scanner;

public class B11053_가장긴증가하는부분수열 {

    static int [] A;
    static Integer [] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A=new int [n];
        dp=new Integer [n];

        for(int i=0;i<n;++i){
            A[i]=sc.nextInt();
        }

        for(int i=0;i<n;++i) LIS(i);

        int max=dp[0];

        for(int i=1;i<n;++i){
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }

    public static int LIS(int n){
        if(dp[n]==null) {
            dp[n]=1;

            for(int i=n-1;i>=0;i--){
                if(A[i]<A[n]){
                    dp[n]=Math.max(dp[n],LIS(i)+1);
                }
            }
        }

        return dp[n];

    }
}
