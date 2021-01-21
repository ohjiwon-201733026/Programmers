package Review;

import java.util.Scanner;

public class B11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] a=new int [n];
		int [] dp=new int[n];

		for(int i=0;i<n;++i) {
			a[i]=sc.nextInt();
			dp[i]=1;
		}

		for(int i=0;i<n;++i) {
			for(int j=0;j<=i;++j) {
				if(a[i]>a[j]&&dp[j]+1>dp[i])
					dp[i]=dp[j]+1;
			}
		}

		int max=0;
		for(int i=0;i<n;++i) {
			max=Math.max(dp[i], max);
		}

		System.out.println(max);


	}

}
