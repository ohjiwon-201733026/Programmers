// 별찍기 16
package BaekJoon.InOutput;

import java.util.Scanner;

public class B10991 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=0;i<n;i++) {

			for(int j=0;j<n-1-i;++j) System.out.print(" ");
			// 첫번째 줄
			if(i==0) {
				System.out.print("*");
				System.out.println();
			}

			// 중간
			if(i!=0) {
			for(int j=0;j<i+1;++j) System.out.print("* ");
			System.out.println();
			}
		}
	}

}
