// 괄호
package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		while(k-->0){

			Stack<Character> stack=new Stack<>();
			String s=br.readLine();
			boolean vps=true;

			for(int j=0;j<s.length();j++) {
				char tmp=s.charAt(j);
				if(tmp=='(') stack.push(tmp);
				else if(tmp==')'){
					if(stack.isEmpty()) {
						vps=false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}


			if(vps&&stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
	}


	}
}