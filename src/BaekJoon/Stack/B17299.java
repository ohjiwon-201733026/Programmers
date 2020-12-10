//오등큰수
package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B17299 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int size=Integer.parseInt(br.readLine());
		String [] temp=br.readLine().split(" ");
		int [] numbers=new int[size];
		int [] counts=new int[1000001];
		int [] answer=new int [size];

		for(int i=0;i<size;i++) {
			numbers[i]=Integer.parseInt(temp[i]);
			counts[numbers[i]]+=1;
			}

		Stack<Integer> stack=new Stack<>();

		stack.push(0);

		for(int i=1;i<size;i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}

			while(!stack.isEmpty()&&counts[numbers[i]]>counts[numbers[stack.peek()]]) {
				answer[stack.pop()]=numbers[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			answer[stack.pop()]=-1;
		}

		for(int i=0;i<size;i++) {
			bw.write(String.valueOf(answer[i]+" "));
		}
		bw.write("\n");
		bw.flush();

		bw.close();
		br.close();
	}

}
