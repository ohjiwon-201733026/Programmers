// 별찍기 5
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=1;i<=n;i++) {
			for(int j=0;j<n-i;++j) System.out.print(" ");
			for(int j=0;j<2*i-1;++j) System.out.print("*");
			System.out.println();
		}

	}

}
