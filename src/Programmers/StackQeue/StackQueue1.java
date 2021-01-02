package Programmers.StackQeue;

import java.util.Scanner;

public class StackQueue1 {

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++) {
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i]>prices[j]) {
        			answer[i]=j-i;
        			break;
        		}
        		if(j==prices.length-1) answer[i]=j-i;

        	}

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
