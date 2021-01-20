package BaekJoon.DynamicProgramming;

import java.util.Scanner;

public class B11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] S=new int[n];
		int [] dp1=new int [n];
		int [] dp2=new int [n];

		for(int i=0;i<n;i++) {
			S[i]=sc.nextInt();
			dp1[i]=1;
			dp2[i]=1;
		}

		for(int i=0;i<n;i++) {

			for(int j=0;j<=i;++j) {
				if(S[i]>S[j]&&dp1[i]<dp1[j]+1)
					dp1[i]=(dp1[j]+1);
			}
		}

		for(int i=n-1;i>=0;i--) {
			for(int k=n-1;k>=i;--k) {
				if(S[i]>S[k]&&dp2[i]<=dp2[k]) // 처음에 안되자나
					dp2[i]=(dp2[k]+1);
			}
		}

		for(int i=0;i<n;i++) {
			dp1[i]=dp1[i]+dp2[i]-1;
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, dp1[i]);
		}
//		for(int i=0;i<n;i++) {
//			System.out.print(dp1[i]+dp2[i]-1+" ");
//		}



		System.out.println(max);

	}

}
