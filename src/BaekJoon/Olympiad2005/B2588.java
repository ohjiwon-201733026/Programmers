//곱셈
package BaekJoon.Olympiad2005;

import java.util.Scanner;

public class B2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();

		int [] arr=new int[4];
		int count=0;
		for(int i=a.length()-1;i>=0;i--) {
			int c=Integer.parseInt(a)*(b.charAt(i)-'0');
			System.out.println(c);
			arr[i]=(int) (c*Math.pow(10, count));
			count++;
		}
		int answer=0;
		for(int i=0;i<arr.length-1;i++) {
			answer+=arr[i];

		}
		System.out.println(answer);

	}

}
