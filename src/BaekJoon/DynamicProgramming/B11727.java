// 2xn 타일링 2
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11727 {
	static int [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new int[N+1];
		dp[0]=1;

		System.out.println(recur(N));

	}

	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(n==1 ||n==0) return 1;
		if(dp[n]>0) return dp[n];

		dp[n]=recur(n-1)+recur(n-2)*2;
		dp[n]=dp[n]%10007;

		return dp[n];
	}

}
