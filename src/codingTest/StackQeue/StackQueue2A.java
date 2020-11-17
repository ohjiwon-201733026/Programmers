package codingTest.StackQeue;

import java.util.Arrays;
import java.util.Scanner;

public class StackQueue2A {
	 public static int[] solution(int[] progresses, int[] speeds) {
	        int [] dayOfend=new int [100];
	        int day=-1;
	        for(int i=0;i<progresses.length;i++) {
	        	while(progresses[i]+(day*speeds[i])<100) day++;
	        	dayOfend[day]++;
	        }

	        return Arrays.stream(dayOfend).filter(i->i!=0).toArray();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int [] progresses=new int[num];
		int [] speeds=new int[num];

		for(int i=0;i<num;i++) {
			progresses[i]=sc.nextInt();
		}
		for(int i=0;i<num;i++) {
			speeds[i]=sc.nextInt();
		}

		int[] answer=solution(progresses,speeds);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}

	}

}
