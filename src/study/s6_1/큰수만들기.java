package study.s6_1;

import java.util.Stack;

public class 큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number="4177252841";
		int k=4;
		String answer=solution(number,k);
		System.out.println(answer);
	}

	private static String solution(String number, int k) {
		// TODO Auto-generated method stub
		int [] num=new int[number.length()];
		for(int i=0;i<number.length();++i) {
			num[i]=number.charAt(i)-'0';
		}
		int K=k;
		Stack<Integer> stack=new Stack<>();
		stack.push(num[0]);
		int i=1;
		for(i=1;i<num.length;++i) {

			while(k>0 && !stack.isEmpty() && stack.peek()<num[i]) {
				stack.pop();
				k--;
			}
			stack.push(num[i]);
		}

		StringBuilder sb=new StringBuilder();
		for(int j=0;j<num.length-K;++j){
			sb.append(stack.get(j));
		}
		return sb.toString();
	}

}
