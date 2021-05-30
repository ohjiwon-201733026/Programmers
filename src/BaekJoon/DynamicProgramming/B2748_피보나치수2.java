package BaekJoon.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class B2748_피보나치수2 {
	public static long [] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new long[n+1];
		Arrays.fill(dp, -1);
		dp[0]=0;
		dp[1]=1;

		dp(n);
		System.out.println(dp[n]);

	}

	private static long dp(int i) {
		// TODO Auto-generated method stub

		if(dp[i]!=-1) return dp[i];

		return dp[i]=dp(i-1)+dp(i-2);

	}


}
