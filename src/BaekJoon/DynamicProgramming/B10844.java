package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B10844 {
	static Integer [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		dp=new Integer [N+1][10];

		for(int i=0;i<10;++i) dp[1][i]=1;

		long result=0;
		for(int i=1;i<10;++i) result+=recur(N,i);

		System.out.println(result%1000000000);

//		for(int j=0;j<dp.length;++j) {
//			for(int i=0;i<10;++i) System.out.print(dp[j][i]+" ");
//			System.out.println();
//		}

	}

	private static int recur(int digit, int val) {
		// TODO Auto-generated method stub

		if(digit==1) return dp[digit][val];

		if(dp[digit][val]==null) {

			if(val==0) {
				dp[digit][val]=recur(digit-1,1);
			}
			else if( val== 9)  {
				dp[digit][val]=recur(digit-1,8);
			}
			else {
				dp[digit][val]=recur(digit-1,val-1)+recur(digit-1,val+1);
			}
		}
		return dp[digit][val]%1000000000;
	}

}
