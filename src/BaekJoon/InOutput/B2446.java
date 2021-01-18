// 별찍기 9
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=0;i<n;++i) {
			for(int j=0;j<i;++j) System.out.print(" ");
			for(int j=1;j<=2*n-(2*i+1);++j) System.out.print("*");
			System.out.println();
		}

		for(int i=n-2;i>=0;--i) {
			for(int j=0;j<i;++j) System.out.print(" ");
			for(int j=1;j<=2*n-(2*i+1);++j) System.out.print("*");
			System.out.println();
		}
	}

}
