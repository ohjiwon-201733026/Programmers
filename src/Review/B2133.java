package Review;

import java.util.Scanner;

public class B2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] dp=new int [N+1];

		if(N%2==0) {
			dp[2]=3;
			for(int i=4;i<N;i+=2) {
				for(int j=2;j<=N;j+=2) {
					dp[i]+=(j==2?3:2)*dp[i-j];
				}
			}

			System.out.println(dp[N]);
		}


	}

}
