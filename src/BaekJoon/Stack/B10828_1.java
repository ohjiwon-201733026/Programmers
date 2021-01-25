package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10828_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();

		for(int i=0;i<N;++i) {
			String a=br.readLine();
			String [] s=a.split(" ");
			switch(s[0]) {
			case "push": {
				int x=Integer.parseInt(s[1]);
				stack.push(x);
				break;

			}
			case "pop":{
				if(stack.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				else {
					int x=stack.pop();
					sb.append(x).append('\n');
					break;
				}
			}
			case "size":{
				sb.append(stack.size()).append('\n');
				break;
			}
			case "empty": sb.append(stack.isEmpty()?"1":"0").append('\n');break;
			case "top" : {
				if(stack.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				else {
					int x=stack.peek();
					sb.append(x).append('\n');
					break;
				}
			}
			}

		}

		System.out.println(sb);

	}

}
