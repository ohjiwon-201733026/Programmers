package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11726_2xn타일링 {
	public static long [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		dp=new long [n];

		System.out.println(recur(n-1)%10007);
	}

	public static long recur(int n) {
		if(n==0) return 1;
		if(n==1) return 2;
		if(dp[n]!=0) return dp[n];

		return dp[n]=(recur(n-1)%10007+recur(n-2)%10007);
	}

}
