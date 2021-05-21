package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {

	public static boolean [] visit;
	public static int N,K;
	public static int min;
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();

		min=Integer.MAX_VALUE;
		cnt=0;

		visit=new boolean [100001];

		if(N>K) {
			System.out.println(N-K);
			System.out.println(1);
		}else {
			bfs(N);
			System.out.println(min);
			System.out.println(cnt);
		}

	}

	public static class Node{
		int x;
		int cnt;

		public Node(int x, int cnt) {
			this.x=x;
			this.cnt=cnt;
		}
	}



	private static void bfs(int v) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(v,0));
		visit[v]=true;

		while(!q.isEmpty()) {
			Node n=q.poll();
			visit[n.x]=true;
			if(n.x==K) {
				if(min>n.cnt) min=n.cnt;
				if(min==n.cnt) cnt++;
				continue;
			}

			for(int i=0;i<3;++i) {
				int x = 0;
				if(i==0) x=n.x-1;
				if(i==1) x=n.x+1;
				if(i==2) x=2*n.x;

				if(0<=x && x<=100000 && !visit[x]) {
					q.add(new Node(x,n.cnt+1));
				}
			}
		}
	}


}
