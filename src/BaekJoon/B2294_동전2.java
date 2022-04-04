package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2294_동전2 {
    static final int INF=100001;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int [] arr=new int [n];
        int [] dp=new int [k+1];
        Arrays.fill(dp,INF);
        dp[0]=0;
        for(int i=0;i<n;++i) {
            arr[i]=sc.nextInt();
            if(0<=arr[i] && arr[i]<=k)dp[arr[i]]=1;
        }


        for(int i=0;i<=k;++i){
            for(int j=0;j<arr.length;++j){
                if(i-arr[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
                }
            }
        }

        System.out.println(dp[k]==100001?-1:dp[k]);
    }
}
