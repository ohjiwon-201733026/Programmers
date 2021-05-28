package BaekJoon.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B13975_파일합치기3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int N=sc.nextInt();
			PriorityQueue<Long> pq=new PriorityQueue<>();
			for(int i=0;i<N;++i) {
				pq.add(sc.nextLong());
			}
			long sum=0;
			while(pq.size()>1) {
				long x1=pq.poll();
				long x2=pq.poll();
				sum+=x1+x2;
				pq.add(x1+x2);
			}
			System.out.println(sum);

	}

	}

}
