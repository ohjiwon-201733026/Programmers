package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();

		Stack<Character> leftStack=new Stack<>();
		Stack<Character> rightStack=new Stack<>();

		for(int i=0;i<s.length();++i) {
			leftStack.push(s.charAt(i));
		}

		int n=Integer.parseInt(br.readLine());
		while(n-->0) {
			String [] a=br.readLine().split(" ");
			switch(a[0]) {
			case "L": {
				if(!leftStack.isEmpty())
					rightStack.push(leftStack.pop());

				break;
			}
			case "D":{
				if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
				break;
			}
			case "B":{
				if(!leftStack.isEmpty()) leftStack.pop();
				break;
			}
			case "P":{
				leftStack.push(a[1].charAt(0));
				break;
			}
			}
		}

		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		StringBuilder sb=new StringBuilder();
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}

		System.out.println(sb);

	}

}
