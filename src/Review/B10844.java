package Review;

import java.util.Scanner;

public class B10844 {
	static Integer [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new Integer[N+1][10];

		for(int i=0;i<10;++i) dp[1][i]=1;

		long result=0;
		for(int i=1;i<10;++i) {
			result+=recur(N,i);
		}

		for(int i=0;i<=N;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println(result%1000000000);

	}
	private static int recur(int digit, int val) {
		// TODO Auto-generated method stub
		if(digit==1) return dp[digit][val];

		if(dp[digit][val]==null) {

			if(val==0) // 0다음은 1만 올 수 있다.
				dp[digit][val]=recur(digit-1,1);

			else if(val==9) //9 다음은 8만 올 수 있다.
				dp[digit][val]=recur(digit-1,8);
			else
			dp[digit][val]=recur(digit-1,val-1)+recur(digit-1,val+1);
		}

		return dp[digit][val]%1000000000;
	}

}
