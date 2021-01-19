// 이친수
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2193 {
	static Long [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		dp=new Long[N+1][2]; // y:0~90,  x: 0,1

		dp[1][0]=0L;
		dp[1][1]=1L;

		long result=0;
		for(int i=0;i<2;++i) result+=recur(N,i);

		System.out.println(result);


	}
	private static long recur(int digit, int val) {
		// TODO Auto-generated method stub

		if(digit==1) return dp[1][val];

		if(dp[digit][val]==null) {
			if(val==0)
				dp[digit][val]=recur(digit-1,0)+recur(digit-1,1);
			if(val==1)
				dp[digit][val]=recur(digit-1,0);
		}

		return dp[digit][val];
	}

}
