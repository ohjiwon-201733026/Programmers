//제로
package BaekJoon.Stack;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<k;i++) {
			Integer n=sc.nextInt();
			if(n==0) stack.pop();
			else  stack.push(n);
		}

		int sum=0;
		while(!stack.empty()){
			sum+=stack.pop();

		}

		System.out.println(sum);
	}

}
