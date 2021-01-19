// 오르막 수
package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11057 {
	static Integer [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new Integer[N+1][10];

		for(int i=0;i<10;i++) dp[1][i]=1;

		int result=0;
//		for(int i=0;i<10;++i)
		for(int i=9;i>=0;--i)
		result+=recur(N,i);

		System.out.println(result%10007);


	}
	private static int recur(int digit, int val) {
		// TODO Auto-generated method stub

		if(digit==1) return dp[digit][val];

		if(dp[digit][val]==null) {
			if(val==9) dp[digit][val]=recur(digit-1,9);

			else{
//				for(int i=val;i<10;++i)
//					dp[digit][val]+=recur(digit-1,i);

				 dp[digit][val]=recur(digit,val+1)+recur(digit-1,val);
			}
		}

		return dp[digit][val]%10007;
	}

}
