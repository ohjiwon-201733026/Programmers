// 구구단
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=1;i<=9;i++) {
			System.out.println(n+" * "+i+" = "+n*i);
		}

	}

}
