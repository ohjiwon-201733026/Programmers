package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] a = br.readLine().split(" "); //String
		int N=Integer.parseInt(a[0]);
		int K=Integer.parseInt(a[1]);
		StringBuilder sb=new StringBuilder();
		String s = br.readLine(); //String

		Stack<Integer> stack=new Stack<>();
		int cnt=0;
		stack.push(s.charAt(0)-'0');
		for(int i=1;i<N;++i)
		{
			int num=s.charAt(i)-'0';

			while(cnt<K && !stack.isEmpty() && stack.peek()<num  ) {
				stack.pop();
				cnt++;
			}

			stack.add(num);

		}
		for(int i=0;i<N-K;++i) {
			sb.append(stack.get(i));
		}

		System.out.println(sb.toString());
	}

}
