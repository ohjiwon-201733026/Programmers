// 별찍기 12
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=1;i<=n;i++) {
			for(int j=0;j<n-i;++j) System.out.print(" ");
			for(int j=0;j<i;++j) System.out.print("*");
			System.out.println();
		}
		for(int i=n-1;i>=1;i--) {
			for(int j=0;j<n-i;++j) System.out.print(" ");
			for(int j=0;j<i;++j) System.out.print("*");
			System.out.println();
		}
	}

}
