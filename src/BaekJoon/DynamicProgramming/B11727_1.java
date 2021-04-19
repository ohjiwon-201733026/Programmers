package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11727_1 {

	public static int [] dp;

	public static int dp(int n) {
		if(n==0) return 1;
		if(n==1) return 3;
		if(dp[n]!=0) return dp[n];
		return dp[n]=(dp(n-1)+2*dp(n-2))%10007;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n];

		System.out.println(dp(n-1));

	}

}
