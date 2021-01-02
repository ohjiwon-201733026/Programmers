package Programmers.StackQeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue3 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q=new LinkedList<>();

        int max=0;
        for(int w:truck_weights) {

        	while(true) {
        		if(q.isEmpty()) {
        		q.offer(w);
        		max+=w;
        		answer++;
        		break;

        	}
        		else if(q.size()==bridge_length) {
        			max-=q.poll();
        		}else {
        			q.offer(w);
        			max+=w;
        			answer++;
        			break;
        		}
        	}
        }




        return answer+bridge_length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int bridge_length=sc.nextInt();
		int weight=sc.nextInt();
		int num=sc.nextInt();
		int [] truck_weights=new int[num];
		for(int i=0;i<num;i++) {
			truck_weights[i]=sc.nextInt();
		}

		int answer=solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}

}
