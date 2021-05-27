package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {

	public static long A,B;
	public static boolean [] visit;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		A=sc.nextLong();
		B=sc.nextLong();
		visit=new boolean [1000000001];

		bfs(A);

	}
	public static class Node{
		long x;
		long cnt;

		public Node(long x, long cnt) {
			this.x=x;
			this.cnt=cnt;
		}
	}

	private static void bfs(long a) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(a,0));
		visit[(int) a]=true;

		while(!q.isEmpty()) {
			Node now=q.poll();

			if(now.x==B) {
				System.out.println(now.cnt);
				return;
			}

			for(int i=0;i<2;++i) {
				long x=0;
				if(i==0) {
					x=10*now.x+1;
				}

				if(i==1) {
					x=2*now.x;
				}

				if(x>=1 && x<=1000000000 && !visit[x]) {

				}
			}
		}

	}

}
