package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2293_123더하기3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
       while(T-->0){
           int n=sc.nextInt();
           int answer=solution(n);
           System.out.println(answer);
       }
    }

    public static int solution(int n){
        int [] dp=new int [n+1];

        dp[0]=1;
        int [] arr={1,2,3};
        for(int i=0;i<3;++i){
            for(int j=arr[i];j<=n;++j){
                dp[j]+=dp[j-arr[i]];
            }
        }

        return dp[n];

    }

}
