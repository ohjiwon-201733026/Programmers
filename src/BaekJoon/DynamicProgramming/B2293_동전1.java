package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2293_동전1 {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int k=sc.nextInt();
       int [] arr=new int [n];
       for(int i=0;i<n;++i){
           arr[i]=sc.nextInt();
       }

       int answer=solution(n,k,arr);
       System.out.println(answer);
    }

    private static int solution(int n, int k, int[] arr) {
        int [] dp=new int [k+1];

        dp[0]=1;
        for(int i=0;i<n;++i){
            for(int j=arr[i];j<=k;++j){
                dp[j]+=dp[j-arr[i]];
            }
        }

        for(int i=0;i<=k;++i){
            System.out.print(dp[i]+" ");
        }
        return dp[k];

    }
}
