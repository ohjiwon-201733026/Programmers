package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B19598_최소회의실 {

	public static class Node implements Comparable<Node>{
		int start;
		int end;

		public Node(int start, int end) {
			this.start=start;
			this.end=end;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.start==o.start) {
				return this.end-o.end;
			}

			return this.start-o.start;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Node[] arr=new Node[N];

		for(int i=0;i<N;++i) {
			arr[i]=new Node(sc.nextInt(),sc.nextInt());
		}

		Arrays.sort(arr);

		PriorityQueue<Integer> pq=new PriorityQueue<>();
		pq.add(arr[0].end);
		for(int i=1;i<N;++i) {
			if(arr[i].start>=pq.peek()) {
				pq.poll();
			}
			pq.add(arr[i].end);

		}
		System.out.println(pq.size());

	}

}
