// 가장 긴 증가하는 부분 수열
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11053 {
	static Integer [] A;
	static Integer [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		A=new Integer[n];
		dp=new Integer[n];

		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();

		for(int i=0;i<n;i++) LIS(i);

		int max=dp[0];

		for(int i=1;i<n;i++)
			max=Math.max(max, dp[i]);
		System.out.println(max);


	}
	private static int LIS(int n) {
		// TODO Auto-generated method stub

		if(dp[n]==null) { // 탐색하지 않은 경우
			dp[n]=1;

			for(int i=n-1;i>=0;--i) {
				if(A[i]<A[n]) dp[n]=Math.max(dp[n], LIS(i)+1);
			}

		}

		return dp[n];
	}

}
