package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B10870_피보나치수5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();


		System.out.println(dp(n));

	}

	private static int dp(int i) {
		// TODO Auto-generated method stub
		if(i==0) return 0;

		if(i==1) return 1;


		return dp(i-1)+dp(i-2);

	}

}
