package BaekJoon.Stack;

import java.util.Scanner;
import java.util.Stack;

public class B10799_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();

		int sum=0;
		Stack<Character> stack=new Stack<>();

		stack.push(s.charAt(0));
		for(int i=1;i<s.length();++i) {
			char c=s.charAt(i);

			if(c=='(') {
				stack.push(c);
			}
			else {
				if(s.charAt(i-1)=='(') {
					stack.pop();
					sum+=stack.size();
				}
				else {
					sum+=1;
					stack.pop();
				}
			}
		}

		System.out.println(sum);

	}

}
