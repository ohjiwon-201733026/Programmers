package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B9095_123더하기 {
	public static int [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int n=sc.nextInt();
			dp=new int [n+1];
			System.out.println(recur(n));

		}

	}

	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;

		else return dp[n]=recur(n-1)+recur(n-2)+recur(n-3);
	}

}
