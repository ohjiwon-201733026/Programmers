// 1로 만들기(DP로 풀기)
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B1463 {
	static int [] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new int[N+1];
		dp[0]=dp[1]=0;

		System.out.println(recur(N));

	}

	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(n==1) return 0;
		if(dp[n]>0) return dp[n];
		dp[n]=recur(n-1)+1;
		if(n%3==0) {
			int tmp=recur(n/3)+1;
			if(dp[n]>tmp) dp[n]=tmp;
		}
		if(n%2==0) {
			int tmp=recur(n/2)+1;
			if(dp[n]>tmp) dp[n]=tmp;
		}

		return dp[n];
	}

}
