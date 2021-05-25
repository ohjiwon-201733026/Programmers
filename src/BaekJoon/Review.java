package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {
	public static int N,K;
	public static boolean [] visit;
	public static int [] dx= {0,1,-1,0};
	public static int [] dy= {1,0,0,-1};

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		visit=new boolean[100001];

		bfs(N);

	}

	private static void bfs(int n) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		visit[n]=true;
		q.add(new Node(n,0));

		while(!q.isEmpty()) {
			Node p=q.poll();
			if(p.x==K) {
				System.out.println(p.cnt);
				return;
			}

			for(int k=0;k<3;++k) {
				int x=0;
				if(k==0) {
					x=p.x*2;
					if(0<=x&& x<=100000 && !visit[x]) {
						q.add(new Node(x,p.cnt));
						visit[x]=true;
					}
				}
				if(k==1) {
					x=p.x-1;
					if(0<=x&& x<=100000 && !visit[x]) {
						q.add(new Node(x,p.cnt+1));
						visit[x]=true;
					}
				}
				if(k==2) {
					x=p.x+1;
					if(0<=x&& x<=100000 && !visit[x]) {
						q.add(new Node(x,p.cnt+1));
						visit[x]=true;
					}
				}

			}

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


}
