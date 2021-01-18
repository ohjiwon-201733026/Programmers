// A+B-7
package BaekJoon.InOutput;

import java.util.Scanner;

public class B11021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=0;i<n;i++) {
			int idx=i+1;
			int A=sc.nextInt();
			int B=sc.nextInt();
			int sum=A+B;
			System.out.println("Case #"+idx+": "+sum); // String 으로 되므로 조심하기!
		}

	}

}
