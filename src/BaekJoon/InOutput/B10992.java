//별찍기
package BaekJoon.InOutput;

import java.util.Scanner;

public class B10992 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<n-1;i++) {
			sb.delete(0,sb.length());
			// 첫줄
			for(int j=0;j<n-1;++j) sb.append(" ");
			sb.append("*");
			sb.append("\n");
			// 중간줄
			if(i!=0) {
				for(int j=1;j<n-1;++j) {
					for(int k=0;k<n-j-1;++k) sb.append(" ");
					sb.append("*");
					for(int k=0;k<2*j-1;++k) sb.append(" ");
					sb.append("*");
					sb.append("\n");
				}

			}
		}

		for(int i=0;i<2*n-1;i++) sb.append("*");

		String s=sb.toString();
		System.out.print(s);
	}



}
