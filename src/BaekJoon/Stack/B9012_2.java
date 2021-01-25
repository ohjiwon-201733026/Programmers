package BaekJoon.Stack;

import java.util.Scanner;
import java.util.Stack;

public class B9012_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		for(int i=0;i<N;++i) {

		String s=sc.next();

		Stack<Character> stack=new Stack<>();
		boolean vps=true;
		for(int k=0;k<s.length();k++) {
			char c=s.charAt(k);
			if(c=='(') stack.push(c);
			else {
				if(stack.isEmpty()) {
					vps=false;
					break;
				}
				stack.pop();
			}
		}

		if(stack.size()==0 && vps==true) System.out.println("YES");
		else System.out.println("NO");

	}
	}

}
