// 최소공배수
package BaekJoon.Mathematics;

import java.util.Scanner;

public class B1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int n=Math.min(a,b);
			int GCD=1;
			for(int i=1;i<=n;++i) {
				if(a%i==0 && b%i==0) GCD=i;
			}

			System.out.println((a*b)/GCD);
		}

	}

}
