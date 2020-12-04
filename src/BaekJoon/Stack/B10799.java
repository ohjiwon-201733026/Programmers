package BaekJoon.Stack;

import java.util.Scanner;
import java.util.Stack;

public class B10799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<Character> stack=new Stack<>();
		String s=sc.next();
		int sum=0;
		for(int i=0;i<s.length();i++) {
			char tmp=s.charAt(i);
			if(tmp=='(') stack.push(tmp);
			else if(tmp==')') {
				if(s.charAt(i-1)=='(') {
				stack.pop();
				sum+=stack.size();
				}else {
					sum+=1; //레이저로 안잘라도 )로 막대기가 끝나면 조각 하나가 추가됨
					stack.pop();
				}
			}
		}

		System.out.println(sum);
	}

}
