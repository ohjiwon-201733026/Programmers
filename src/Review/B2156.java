package Review;

import java.util.Scanner;

public class B2156 {
	public static Integer [] dp;
	public static Integer [] wine;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new Integer[n+1];
		wine=new Integer[n+1];

		for(int i=1;i<=n;++i) {
			wine[i]=sc.nextInt();
		}
		dp[0]=0;
		dp[1]=wine[1];
		if(n>1) {
			dp[2]=wine[1]+wine[2];
		 }

		System.out.println(recur(n-1));

	}
	private static int recur(int n) {
		// TODO Auto-generated method stub

		if(dp[n]==null) {

			dp[n]=Math.max(Math.max(recur(n-3)+wine[n-1]+wine[n], recur(n-2)+wine[n]), recur(n-1));
		}
		return dp[n];
	}

}
