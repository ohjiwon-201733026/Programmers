package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C14852_2 {

	public static long [][] dp;

	public static long dp(int n) {
		dp[0][0]=0;
		dp[1][0]=2;
		dp[2][0]=7;
		dp[2][1]=1;
		for(int i=3;i<=n;++i) {
			dp[i][1]=dp[i-3][0]+dp[i-1][1]%1000000007;
			dp[i][0]=(3*dp[i-2][0]+2*dp[i-1][0]+2*dp[i][1])%1000000007;
		}
		return dp[n][0];

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		dp=new long[1000001][2];

		System.out.println(dp(n));
	}

}
