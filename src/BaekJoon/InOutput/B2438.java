//별찍기1
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;++j) System.out.print("*");
			System.out.println();
		}

	}

}
