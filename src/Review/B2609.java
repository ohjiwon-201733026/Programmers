package Review;

import java.util.Scanner;

public class B2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();

		long GCD=getGCD(Math.max(A, B),Math.min(A, B));
		long LCM=getLCM(A,B,GCD);

		System.out.println(GCD);
		System.out.println(LCM);
	}

	private static long getLCM(int a, int b, long gCD) {
		// TODO Auto-generated method stub
		return (a*b)/gCD;
	}

	private static long getGCD(long a, long b) {
		// TODO Auto-generated method stub
		while(b>0) {
			long tmp=a;
			a=b;
			b=tmp%b;
		}
			return a;
	}

}
