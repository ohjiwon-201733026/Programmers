package BaekJoon.Mathematics;

import java.util.Scanner;

public class B9613 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int n=sc.nextInt();

			int [] a=new int[n];
			for(int i=0;i<n;++i) a[i]=sc.nextInt();
			long sum=0;

			for(int i=0;i<a.length-1;++i) {
				for(int j=i+1;j<a.length;++j)
					sum+=GCD(a[i],a[j]);
			}
			System.out.println(sum);

		}

	}

	private static long GCD(long a, long b) {
		// TODO Auto-generated method stub

		while(b>0) {
			long tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
	}

}
