// 거스름 돈
package BaekJoon.Greedy;

import java.util.Scanner;

public class B5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int n=1000-x;
		int cnt=0;

		cnt+=n/500;
		n=n%500;

		cnt+=n/100;
		n=n%100;

		cnt+=n/50;
		n=n%50;

		cnt+=n/10;
		n=n%10;

		cnt+=n/5;
		n=n%5;

		cnt+=n/1;

		System.out.println(cnt);
	}

}
