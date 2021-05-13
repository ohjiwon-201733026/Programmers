package BaekJoon.Greedy;

import java.util.Scanner;

public class B2720_세탁소사장동혁 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int T=sc.nextInt();
		int q=0,d=0,n=0,p=0;

		while(T-->0) {
			int c=sc.nextInt();
			q=c/25;
			c=c%25;
			d=c/10;
			c=c%10;
			n=c/5;
			c=c%5;

			p=c/1;
			c=c%1;

			sb.append(q+" "+d+" "+n+" "+p+"\n");
		}

		System.out.println(sb.toString());
	}

}
