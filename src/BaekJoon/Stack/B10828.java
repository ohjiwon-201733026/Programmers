//스택
package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10828 {


	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[] stack=new int[n];
		 int top = 0;

		for(int i=0;i<n;i++) {
			String [] s=br.readLine().split(" ");
			switch(s[0]) {
			case "push":{
				int num=Integer.parseInt(s[1]);
				stack[top]=num;
				top++;
				break;
			}
			case "pop":{
				if(top==0) bw.write("-1"+"\n");
				else {
					bw.write(stack[top-1]+"\n");
					top--;
				}
				break;
			}
			case "size":{
				bw.write(top+"\n");
				break;
			}
			case "empty":{
				bw.write(top==0?"1":"0"+"\n");
				break;
			}
			case "top":{
				if(top==0) bw.write("-1"+"\n");
				else{bw.write(stack[top-1]+"\n");}
				break;
			}

			}
		}

	}

}