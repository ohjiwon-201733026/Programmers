// 연속합
package Review;

import java.util.Scanner;

public class B1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int  n=sc.nextInt();
		int [] a=new int [n];
		int [] dp=new int[n];

		for(int i=0;i<n;++i) {
			a[i]=sc.nextInt();
		}
		dp[0]=a[0];

		for(int i=1;i<n;i++) {
			dp[i]=Math.max(dp[i-1]+a[i], a[i]);
		}


		int max=dp[0];
		for(int i=0;i<n;++i) {
			max=Math.max(max,dp[i]);
		}
		System.out.println(max);
	}

}
