// 포도주 시식
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2156 {
	public static Integer [] score;
	public static Integer [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		score=new Integer[N+1];
		dp=new Integer[N+1];

		for(int i=1;i<=N;i++) score[i]=sc.nextInt();

		dp[1]=score[1];
		dp[2]=score[1]+score[2];

		int result=recur(N);
		System.out.println(result);

		for(int i=1;i<=N;i++) {
			System.out.println(dp[i]);
		}

	}
	private static int recur(int n) {
		// TODO Auto-generated method stub

		if(n==1) return dp[n];

		if(dp[n]==null) {
			dp[n]=Math.max(recur(n-1)+score[n], recur(n-2)+score[n]);
		}

		return dp[n];
	}

}
