// Dequeue
package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());


		Deque<Integer> deq=new LinkedList<>();
		StringBuilder sb=new StringBuilder();

		while(N-->0) {

			String [] a=br.readLine().split(" ");
		switch(a[0]) {
		case "push_front":{
			int x=Integer.parseInt(a[1]);
			deq.addFirst(x); break;
		}
		case "push_back":{
			int x=Integer.parseInt(a[1]);
			deq.addLast(x); break;
		}
		case "pop_front":{
			if(deq.isEmpty()) {
				sb.append(-1).append('\n');break;
			}else {
				int x=deq.removeFirst();
				sb.append(x).append('\n');break;
			}
		}
		case "pop_back":{
			if(deq.isEmpty()) {
				sb.append(-1).append('\n');break;
			}else {
				int x=deq.removeLast();
				sb.append(x).append('\n');break;
			}
		}
		case "size":{
			sb.append(deq.size()).append('\n'); break;
		}
		case "empty":{
			sb.append(deq.isEmpty()?1:0).append('\n');break;
		}
		case "front":{
			if(deq.isEmpty()) {
				sb.append(-1).append('\n');break;
			}else {
				int x=deq.peekFirst();
				sb.append(x).append('\n');break;
			}
		}
		case "back":{
			if(deq.isEmpty()) {
				sb.append(-1).append('\n');break;
			}else {
				int x=deq.peekLast();
				sb.append(x).append('\n');break;
			}
		}

		}
		}

		System.out.println(sb.toString());
	}

}
