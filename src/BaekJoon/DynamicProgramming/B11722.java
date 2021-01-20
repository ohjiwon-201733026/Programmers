package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] A=new int [n];
		int [] dp=new int [n];

		for(int i=0;i<n;i++) {
			A[i]=sc.nextInt();
			dp[i]=1;
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;++j) {
				if(A[i]<A[j] && dp[j]>=dp[i])
					dp[i]=dp[j]+1;
			}
		}

		int max=0;
		for(int i=0;i<n;i++)
			max=Math.max(max, dp[i]);
		System.out.println(max);


	}

}
