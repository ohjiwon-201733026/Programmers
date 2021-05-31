package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B1010_다리놓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int [][] dp=new int [N+1][M+1];

			for(int i=0;i<=M;++i) dp[1][i]=i;
			for(int i=2;i<=N;++i) {
				for(int j=i;j<=M;++j) {
					if(i==j) dp[i][j]=1;
					else dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
				}
			}

			System.out.println(dp[N][M]);

		}

	}

}
