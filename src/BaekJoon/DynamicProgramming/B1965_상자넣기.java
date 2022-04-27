package BaekJoon.DynamicProgramming;

import com.sun.source.tree.LiteralTree;

import java.util.Scanner;

public class B1965_상자넣기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int [] a=new int [n];
        int [] dp=new int [n];
        for(int i=0;i<n;++i){
            a[i]=sc.nextInt();
        }

        dp[0]=1;
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                if(a[j]<a[i]) dp[i]=Math.max(dp[i],dp[j]);
            }
            dp[i]++;
        }

        int max=0;
        for (int i : dp) {
            max=Math.max(max,i);
        }

        System.out.println(max);

    }
}
