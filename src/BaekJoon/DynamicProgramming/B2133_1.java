package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2133_1 {

	public static int [] dp;

	public static int dp(int n) {
		if(n==0) return 1;
		if(n==1) return 0; //1개
		if(n==2) return 3; //2개
		if(dp[n]!=0) return dp[n];
		int result=dp(n-2)*3;

			for(int i=3;i<=n;++i) {
				if(i%2==0) {
					result+=dp(n-i)*2;
				}
			}

			return dp[n]=result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n+1];

		System.out.println(dp(n));
	}

}
