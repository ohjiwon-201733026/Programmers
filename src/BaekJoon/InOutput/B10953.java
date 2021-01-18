package BaekJoon.InOutput;

import java.util.Scanner;

public class B10953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			String s=sc.next();
			String[] a=s.split(","); // String split 메소드

			System.out.println(Integer.parseInt(a[0])+Integer.parseInt(a[1]));
		}


	}

}
