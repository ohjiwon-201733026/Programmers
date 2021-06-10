import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int [] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0){
			int n=sc.nextInt();
			dp=new int [n+1];
			System.out.println(recur(n));
		}


	}

	private static int recur(int n) {
		if(n==1) return dp[1]=1;
		if(n==2) return dp[2]=2;
		if(n==3) return dp[3]=4;

		return dp[n]=recur(n-3)+recur(n-2)+recur(n-1);
	}

}
