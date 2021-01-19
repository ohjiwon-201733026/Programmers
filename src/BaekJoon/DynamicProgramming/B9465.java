package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B9465 {
	static Integer [][] score;
	static Integer [][] dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		for(int i=0;i<T;i++) { // 테스트케이스
			N=sc.nextInt();
			score=new Integer[2][N];
			dp=new Integer[2][N];

			for(int j=0;j<2;++j) {
				for(int k=0;k<N;++k) {
					score[j][k]=sc.nextInt();
				}
			}

			dp[0][0]=score[0][0];
			dp[1][0]=score[1][0];
			dp[0][1]=score[0][1]+score[1][0];
			dp[1][1]=score[1][1]+score[0][0];




			int result=Math.max(recur(0,N-1), recur(1,N-1)); // N-1-> nullpointer exception

			System.out.println(result);

		}

	}
	private static int recur(int i, int n) {
		// TODO Auto-generated method stub

		if(n==0 || n==1) return dp[i][n];

		if(dp[i][n]==null) {

				dp[i][n]=Math.max(recur(1,n-1), Math.max(recur(0, n-2),recur(1,n-2)))+score[i][n];

			if(i==1)
				dp[i][n]=Math.max(recur(1,n-2), Math.max(recur(0, n-2),recur(0,n-1)))+score[i][n];
		}

		return dp[i][n];
	}

}
