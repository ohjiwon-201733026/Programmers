package Review;

import java.util.Scanner;

public class B11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] a=new int[N];
		int [] dp1=new int [N];
		int [] dp2=new int [N];

		for(int i=0;i<N;++i) {
			a[i]=sc.nextInt();
			dp1[i]=1;
			dp2[i]=1;
		}

		for(int i=0;i<N;++i) {
			for(int j=0;j<=i;++j) {
				if(a[i]>a[j] && dp1[i]<dp1[j]+1)
					dp1[i]=dp1[j]+1;
			}
		}

		for(int i=N-1;i>=0;--i) {
			for(int j=N-1;j>=i;--j) {
				if(a[i]>a[j] && dp2[i]<dp2[j]+1)
					dp2[i]=dp2[j]+1;
			}
		}


		for(int i=0;i<N;++i) {
			dp1[i]+=dp2[i]-1;
		}

		int max=0;
		for(int i=0;i<N;++i)
			max=Math.max(max, dp1[i]);

		System.out.println(max);

	}

}
