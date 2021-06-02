package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B2579_계단오르기 {

	public static int [] arr;
	public static Integer [] dp;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N+1];
		dp=new Integer [N+1];

		for(int i=1;i<=N;++i) {
			arr[i]=sc.nextInt();
		}
		dp[0]=0;
		dp[1]=arr[1];

		if(N>=2) {
			dp[2]=dp[1]+arr[2];
		}


		recur(N);
		System.out.println(dp[N]);

	}

	static int recur(int n) {
		if(dp[n]!=null) return dp[n];

		return dp[n]=Math.max(recur(n-3)+arr[n-1], recur(n-2))+arr[n];
	}
}
