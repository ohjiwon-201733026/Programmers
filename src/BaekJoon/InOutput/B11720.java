// 숫자의 합
package BaekJoon.InOutput;

import java.util.Scanner;

public class B11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=0;
		String s=sc.next();
		for(int i=0;i<n;i++) {

			sum+=s.charAt(i)-'0';
		}
		System.out.println(sum);
	}

}
