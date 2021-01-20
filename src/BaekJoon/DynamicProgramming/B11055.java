package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11055 {
	static Integer [] A;
	static Integer [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		A=new Integer[n];
		dp=new Integer[n];

		for(int i=0;i<n;i++) {
			A[i]=sc.nextInt();
			dp[i]=A[i];
		}


		for(int i=0;i<n;i++) {
			for(int j=0 ; j<=i ; j++){
				if(A[i]>A[j] && dp[j]+A[i]>dp[i]) {
					dp[i]=dp[j]+A[i];
				}
			}
		}

		int max=dp[0];

		for(int i=1;i<n;i++)
			max=Math.max(max, dp[i]);
		System.out.println(max);


	}


}
