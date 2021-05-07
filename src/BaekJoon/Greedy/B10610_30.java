package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B10610_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int [] a=new int[s.length()];
		int sum=0;
		StringBuilder result = new StringBuilder();
		for(int i=0;i<a.length;++i) {
			sum+=s.charAt(i)-'0';
			a[i]=s.charAt(i)-'0';
		}

		Arrays.sort(a);


		if(a[0]==0 && sum%3==0) {
			for(int i=a.length-1;i>=0;--i) result.append(Integer.toString(a[i]));
		}
		else {
			System.out.println(-1);
			return;
		}

		System.out.println(result);



	}

}
