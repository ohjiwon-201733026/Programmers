package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] dp = new int[n+1];

        dp[0] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = 3*dp[i-2];
            for(int j=i-4; j>=0; j-=2)
                dp[i]+=2*dp[j];
        }
        System.out.println(dp[n]);


	}

}
