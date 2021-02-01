package BaekJoon.Mathematics;

import java.util.Scanner;

public class B2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();

		int min=A>B?B:A;
		int MIN=1;
		for(int i=1;i<=min;++i) {
			if(A%i==0 && B%i==0) MIN=i;
		}

		System.out.println(MIN);

		System.out.println((A*B/MIN));

	}

}
