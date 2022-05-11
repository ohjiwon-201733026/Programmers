package BaekJoon.삼성SW역량;

import java.io.IOException;
import java.util.Scanner;

public class B14501_퇴사 {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] t=new int [n];
        int [] p=new int [n];

        for(int i=0;i<n;++i){
            t[i]=sc.nextInt();
            p[i]=sc.nextInt();
        }
        int [] dp=new int [n+1];

        for(int i=0;i<n;++i){
            if(i+t[i]<=n){
                dp[i+t[i]]=Math.max(dp[i+t[i]],dp[i]+p[i]);
            }
            dp[i+1]=Math.max(dp[i],dp[i+1]);
        }

        System.out.println(dp[n]);

    }
}
