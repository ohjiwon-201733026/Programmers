package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11726_1 {

	public static long [] dp;

	public static long dp(int x) {
		if(x==0) return 1;
		if(x==1) return 2;
		if(dp[x]!=0) return dp[x];
		return dp[x]=(dp(x-2)%10007+dp(x-1)%10007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new long[n];

		System.out.println(dp(n-1)%10007);


	}

}
