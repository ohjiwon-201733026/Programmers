package Review;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		while(N-->0) {
			String s=sc.next();

			Stack<Character> stack=new Stack<>();
			boolean vps=true;
			for(int i=0;i<s.length();++i) {
				char c=s.charAt(i);
				if(c=='(') stack.push(c);
				else {
					if(stack.isEmpty()) {
						vps=false;
						break;
					}else {
						stack.pop();
					}
				}

			}


			if(stack.size()==0&&vps==true) System.out.println("YES");
			else System.out.println("NO");
		}

	}

}
