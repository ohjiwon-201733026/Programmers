package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11727_2xn타일링2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long [] dp=new long [n+1];

		dp[1]=1;
		if(n>=2) dp[2]=3;


		for(int i=3;i<=n;++i) {
			dp[i]=(dp[i-1]%10007+2*dp[i-2]%10007);
		}

		System.out.println(dp[n]%10007);


	}

}
