package Review;

import java.util.Scanner;

public class B11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] a=new int [n];
		int [] dp=new int[n];

		for(int i=0;i<n;++i) {
			a[i]=sc.nextInt();
			dp[i]=a[i];
		}

		for(int i=0;i<n;++i) {
			for(int j=0;j<=i;++j) {
				if(a[i]>a[j]&&dp[j]+a[i]>dp[i])
					dp[i]=dp[j]+a[i];
			}
		}

		int max=0;
		for(int i=0;i<n;++i) {
			max=Math.max(dp[i], max);
		}

		System.out.println(max);


	}

}
