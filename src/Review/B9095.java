package Review;

import java.util.Scanner;

public class B9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] dp=new int [11];
		dp[0]=dp[1]=1;
		dp[2]=2;

		for(int i=3;i<=N;i++) {
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		}

		System.out.println(dp[N]);

	}

}
