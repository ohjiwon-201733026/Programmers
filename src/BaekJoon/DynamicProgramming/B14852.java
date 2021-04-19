package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14852 {

	public static int [] dp;

	public static int dp(int n) {
		if(n==0) return 1;
		if(n==1) return 2;
		if(n==2) return 7;
		if(dp[n]!=0) return dp[n];
		int result=dp(n-1)*2+dp(n-2)*3;
		for(int i=3;i<=n;++i) {
			result+=(dp(n-i)*2)%1000000007;
		}

		return dp[n]=result%1000000007;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		dp=new int[n+1];

		System.out.println(dp(n));
	}

}
