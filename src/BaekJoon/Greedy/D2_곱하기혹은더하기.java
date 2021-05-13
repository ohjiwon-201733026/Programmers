package BaekJoon.Greedy;

import java.util.Scanner;

public class D2_곱하기혹은더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int result=s.charAt(0)-'0';

		for(int i=1;i<s.length();++i) {
			int num=s.charAt(i)-'0';
			if(num<=1 || result<=1) {
				result+=num;
			}
			else {
				result*=num;
			}

		}

		System.out.println(result);

	}

}
