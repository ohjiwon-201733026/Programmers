package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int [] a=new int[T];
		long [] dp=new long[101];

		for(int i=0;i<T;++i) a[i]=sc.nextInt();

		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;

		for(int i=6;i<=100;++i) {
			dp[i]=dp[i-1]+dp[i-5];
//			int c=i-1;
//			int b=i-4;
//			System.out.println(i+" "+c+" + "+b+" "+dp[i]);
		}

		for(int i=0;i<T;++i) {
//			System.out.println(i+" "+dp[i]);
			System.out.println(dp[a[i]]);
		}
	}

}
