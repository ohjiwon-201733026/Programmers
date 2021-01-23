package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] P=new int[N+1];
		int [] dp=new int [N+1];

		for(int i=1;i<=N;++i) {
			P[i]=sc.nextInt();
			dp[i]=P[i];
		}


		for(int i=2;i<=N;++i) {
			for(int j=0;j<=i;++j)
				dp[i]=Math.max(dp[i], dp[i-j]+dp[j]);
		}

//		for(int i=0;i<dp.length;++i)
			System.out.println(dp[N]);

	}

}
