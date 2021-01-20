package Review;

import java.util.Scanner;

public class B11726 {
	static Integer [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		dp=new Integer[N+1];
		dp[0]=dp[1]=1;

		int result=recur(N);
		System.out.println(result);
	}
	private static int recur(int n) {
		// TODO Auto-generated method stub

		if(dp[n]==null) {
			dp[n]=recur(n-1)+recur(n-2);
		}
		return dp[n]%10007;
	}

}
