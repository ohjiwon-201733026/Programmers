package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2294_동전2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int [] arr=new int [n];

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        int [] dp=new int [k+1];

        Arrays.fill(dp,100001);

        for(int i=0;i<arr.length;++i){
            if(0<= arr[i] && arr[i]<=k) dp[arr[i]]=1;
        }

        for(int i=1;i<=k;++i){ // 10000
            for(int j=0;j<arr.length;++j){ //100
                int idx=i+arr[j];
                if(0<=idx && idx<=k){
                    dp[idx]=Math.min(dp[idx],dp[i]+1);
                }
            }
        }
        System.out.println(dp[k]==100001?-1:dp[k]);
    }
}
