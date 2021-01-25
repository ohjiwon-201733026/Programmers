package BaekJoon.Stack;

import java.util.Scanner;

public class B9012_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		for(int i=0;i<N;++i) {

			String s=sc.next();

			int sum=0;
			for(int j=0;j<s.length();++j) {
				if(s.charAt(j)=='(') sum+=1;
				else sum-=1;
				if(sum<0) {
					break;
				}
			}
			if(sum==0) System.out.println("YES");
			else System.out.println("NO");

		}


	}

}
