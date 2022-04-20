package BaekJoon;

import java.util.Scanner;

public class B19951_태상이의훈련소생활 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] arr=new int [n+1];
        int [] dp=new int [n+2];

        for(int i=1;i<=n;++i) arr[i]=sc.nextInt();

        while (m-->0){
            int s=sc.nextInt();
            int e=sc.nextInt();
            int degree=sc.nextInt();
            dp[s]+=degree;
            dp[e+1]-=degree;
        }

        for(int i=2;i<dp.length;++i){
            dp[i]+=dp[i-1];
        }

        for(int i=1;i<=n;++i){
            System.out.print(dp[i]+arr[i]+" ");
        }
    }
}
