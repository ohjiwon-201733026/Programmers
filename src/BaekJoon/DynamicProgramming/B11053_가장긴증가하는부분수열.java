package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			A[i] = sc.nextInt();
		}

		dp[0] = 1;

		for (int i = 1; i < n; ++i) {
			dp[i] = 1;
			int maxVal=0;
			for (int j = 0; j < i; ++j) {
				if (A[j] < A[i]) {
					if(maxVal<dp[j]+1) maxVal=dp[j];
//					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			dp[i]=maxVal+1;
		}

		int max = Integer.MIN_VALUE;

		for (int j = 0; j < n; j++) { // 최종 dp배열 중 가장 큰 값이 가장 긴 수열이 된다.
			if (dp[j] > max) {
				max = dp[j];
			}
		}
		System.out.println(max);
	}

}
