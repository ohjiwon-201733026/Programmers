package codingTest.StackQeue;
/*기능 개발*/

import java.util.Scanner;
import java.util.Stack;

public class StackQueue2 {
	 public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        Stack<Integer> stack=new Stack<>();
	        double [] term=new double[speeds.length];

	        for(int i=0;i<speeds.length;i++) {
	        	term[i]=Math.ceil((100.0-progresses[i])/speeds[i]);
	        }

	        int count=1;
	        for(int i=0;i<term.length;i++) {
	        	count=1;
	        	for(int j=i+1;j<term.length;j++) {
	        		if(term[i]<term[j]) {
	        			System.out.println(j-i);
	        			break;
	        		}

	        	}

	        }

	        return answer;
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
//		for(int i=0;i<answer.length;i++) {
//			System.out.println(answer[i]);
//		}

	}

}
