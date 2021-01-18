// 별찍기 3
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2440 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int k=0;k<n;k++) {
			for(int i=n-k;i>=1;--i) {
				System.out.print("*");
			}
		System.out.println();
		}

	}

}
