package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B11053_가장긴증가하는부분수열 {

    static int [] A;
    static int [] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        A=new int [n];
        dp=new int [n];

        for(int i=0;i<n;++i){
            A[i]=sc.nextInt();
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(A[j]<A[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
        }

        int max=0;
        for (Integer integer : dp) {
            max=Math.max(integer,max);
        }
        System.out.println(max);

    }
}
