package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B17626_FourSquares {

	public static int[] dp;
	public static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		recur(N);
		System.out.println(dp[N]);

	}

	static void recur(int n) {
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;
		}
	}

}
