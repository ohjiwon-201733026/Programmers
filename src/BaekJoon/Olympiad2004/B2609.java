//최대공약수와 최소공배수
package BaekJoon.Olympiad2004;

import java.util.Scanner;

public class B2609 {

	public static long getGCD(long a, long b) {
		while(b>0) {
			long tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
	}

	public static long getLCM(long a, long b, long gcd) {
		return (a*b)/gcd;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b= sc.nextInt();

//		int n=a>b?b:a;
//		int max=0; // 최대공약수
//		int min=0; // 최소공배수
//		for(int i=1;i<=n;i++) {
//			if(a%i==0&&b%i==0) max=i;
//		}
//		Loop1 :
//		for(int i=1;i<=b;i++) {
//			for(int j=1;j<=a;j++) {
//				if(a*i==b*j) {
//					min=a*i; break Loop1;
//				}
//			}
//		}

		long gcd=getGCD(Math.max(a, b),Math.min(a, b));
		long lcm=getLCM(a,b,gcd);
		System.out.println(gcd);
		System.out.println(lcm);


	}

}
