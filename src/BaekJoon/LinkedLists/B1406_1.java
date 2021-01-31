package BaekJoon.LinkedLists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1406_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine(); // abcd

		Stack<Character> leftStack=new Stack<>();
		Stack<Character> rightStack=new Stack<>();
		for(int i=0;i<s.length();++i) {
			leftStack.push(s.charAt(i));
		}

		int N=Integer.parseInt(br.readLine());
		while(N-->0) {
			String [] a=br.readLine().split(" ");
			switch(a[0]) {
			case "L":{
				if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
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
			case "P" :{
				char x=a[1].charAt(0);
				leftStack.push(x);
				break;
			}
			}


		}

		while(!leftStack.isEmpty()) rightStack.push(leftStack.pop());

		while(!rightStack.isEmpty())
			bw.write(rightStack.pop());

		bw.flush();
		bw.close();

	}

}
