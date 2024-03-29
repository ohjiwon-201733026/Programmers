package Review;

import java.util.Scanner;

public class B2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] wine=new int[N+1];
		int [] dp= new int[N+1];

		for(int i=1;i<=N;++i)
			wine[i]=sc.nextInt();

		dp[1]=wine[1];
		if(N>=2) {
			dp[2]=dp[1]+wine[2];
		}

		for(int i=3;i<=N;++i) {
			dp[i]=Math.max(Math.max(dp[i-3]+wine[i-1],dp[i-2])+wine[i], dp[i-1]);
		}

		System.out.println(dp[N]);

	}

}
