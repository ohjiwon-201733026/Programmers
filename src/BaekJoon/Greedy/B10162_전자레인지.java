package BaekJoon.Greedy;

import java.util.Scanner;

public class B10162_전자레인지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int a=0,b=0,c=0;


			if(T>=300) {
				a=T/300;
				T-=300*a;
			}
			if(T>=60) {
				b=T/60;
				T-=60*b;
			}
			if(T%10!=0) {
				System.out.println(-1);
				return;
			}
			else {
				c=T/10;
			}

		System.out.println(a+" "+b+" "+c);


	}

}
