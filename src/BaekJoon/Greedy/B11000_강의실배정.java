package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11000_강의실배정 {
	public static class Lecture implements Comparable<Lecture>{
		int start;
		int end;

		public Lecture(int start, int end) {
			this.start=start;
			this.end=end;
		}

		@Override
		public int compareTo(Lecture o1) {
			// TODO Auto-generated method stub
			if(o1.start==this.start) {
				return this.end-o1.end;
			}
			return this.start-o1.start;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Lecture [] a=new Lecture [N];

		for(int i=0;i<N;++i) {
			a[i]=new Lecture(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(a);
		PriorityQueue<Integer> pq=new PriorityQueue<>();

		pq.add(a[0].end);
		for(int i=1;i<N;++i) {
			if(a[i].start>=pq.peek()) {
				pq.poll();
			}
			pq.add(a[i].end);
		}

		System.out.println(pq.size());

	}


}
