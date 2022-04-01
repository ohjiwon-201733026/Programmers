package BaekJoon;

import java.util.Scanner;

public class B2293_동전1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int [] dp=new int [k+1];
        int [] arr=new int [n];

        dp[0]=1;
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
            for(int j=arr[i];j<=k;++j){
                dp[j]+=dp[j-arr[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
