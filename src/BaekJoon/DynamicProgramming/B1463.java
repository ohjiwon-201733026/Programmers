// 1로 만들기
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B1463 {
	static Integer [] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new Integer[N+1];
		dp[0]=dp[1]=0;

		System.out.println(recur(N));

	}

	private static int recur(int n) {
		// TODO Auto-generated method stub

		if(dp[n]==null) {

			// 6으로 나눠지는 경우
			if(n%6==0) dp[n]=Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2)))+1;
			// 3으로만 나눠지는 경우
			else if(n%3==0) dp[n]=Math.min(recur(n/3), recur(n-1))+1;
			// 2로만 나눠지는 경우
			else if(n%2==0) dp[n]=Math.min(recur(n/2),recur(n-1))+1;
			//-1
			else dp[n]=recur(n-1)+1;
		}


		return dp[n];
	}

}
