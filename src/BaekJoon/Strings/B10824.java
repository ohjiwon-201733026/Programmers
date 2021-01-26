package BaekJoon.Strings;

import java.util.Scanner;

public class B10824 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();
		String C=sc.next();
		String D=sc.next();

		Long a=Long.parseLong(A+B);
		Long b=Long.parseLong(C+D);

		System.out.println(a+b);

	}

}
