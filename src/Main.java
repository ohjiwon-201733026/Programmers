import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int [] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		dp= new int [n+1];
		System.out.println(dp(n));
	}

	private static int dp(int n) {
		if(n==1) return 0;
		if(n==2) return 1;

		if(n%3==0) return dp[n]=dp(n/3)+1;
		if(n%2==0) return dp[n]=dp(n/2)+1;
		dp[n]=dp[n-1]+1;
		return dp[n];
	}


}
