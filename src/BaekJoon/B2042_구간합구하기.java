package BaekJoon;

import java.util.Scanner;

public class B2042_구간합구하기 {
    static int [] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        int [] arr=new int [n+1];
        for(int i=1;i<=n;++i){
            arr[i]=sc.nextInt();
        }

        dp=new int [n+1];
        for(int i=1;i<=n;++i) dp[i]=dp[i-1]+arr[i];


        for(int i=0;i<m+k;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a==1){
                int d=c-arr[b];
                arr[b]=c;
                change(b,arr,d);
            }
            else{
                System.out.println(dp[c]-dp[b-1]);
            }
        }
    }

    public static void change(int b, int[] arr, int d){
        for(int i=b;i<dp.length;++i){
            dp[i]+=d;
        }
    }
}
