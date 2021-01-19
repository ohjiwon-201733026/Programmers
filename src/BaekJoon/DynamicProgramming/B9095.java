// 1,2,3 더하기
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B9095 {

	static int [] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		for(int i=0;i<T;++i) {

			int N=sc.nextInt();
			dp=new int[11]; // index : 0~N
			dp[0]=dp[1]=1;
			dp[2]=2;

			System.out.println(recur(N));

		}

	}

	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(n==0|| n==1) return 1;
		if(n==2) return 2;
		if(dp[n]>0) return dp[n];

		dp[n]=recur(n-1)+recur(n-2)+recur(n-3);

		return dp[n];
	}

}
