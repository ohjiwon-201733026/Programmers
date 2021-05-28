package BaekJoon.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715_카드정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<N;++i) {
			pq.add(sc.nextInt());
		}
		int sum=0;
		while(pq.size()>1) {
			int x1=pq.poll();
			int x2=pq.poll();
			sum+=x1+x2;
			pq.add(x1+x2);
		}

		System.out.println(sum);

	}

}
