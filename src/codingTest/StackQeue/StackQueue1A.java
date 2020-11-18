package codingTest.StackQeue;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue1A {
	public static int[] solution(int[] prices) {
		Stack<Integer> beginIdxs=new Stack<>();
		int [] answer=new int[prices.length];
		int i=0;

		beginIdxs.push(i);
		for(i=1;i<prices.length;i++){
		while(!beginIdxs.empty()&&prices[i]<prices[beginIdxs.peek()]) {
			int beginIdx=beginIdxs.pop();
			answer[beginIdx]=i-beginIdx;
		}
			beginIdxs.push(i);
		}
		while(!beginIdxs.empty()) {
			int beginIdx=beginIdxs.pop();
			answer[beginIdx]=i-beginIdx-1;
		}

        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int [] prices=new int[num];

		for(int i=0;i<num;i++) {
			prices[i]=sc.nextInt();
		}

		int [] answer=solution(prices);
		for(int i=0;i<answer.length;i++)
		{
			System.out.println(answer[i]);
		}

	}

}
