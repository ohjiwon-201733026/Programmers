package BaekJoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697_1 {

	public static int N,K;
	public static boolean [] visit;

	public static class Pair{
		int x;
		int cnt;

		Pair(int x, int cnt){
			this.x=x;
			this.cnt=cnt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		visit=new boolean[100001];

		bfs(N,K);

	}

	private static void bfs(int n, int k) {
		// TODO Auto-generated method stub
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(n,0));
		visit[n]=true;

		while(!q.isEmpty()) {
			Pair p=q.poll();

			if(p.x==k) {
				System.out.println(p.cnt);
				return;
			}
			int x = 0;
			for(int t=0;t<3;++t) {
				if(t==0) x=p.x-1;
				if(t==1) x=p.x+1;
				if(t==2) x=2*p.x;

				if(0<=x && x<=100000 && !visit[x]) {
					q.add(new Pair(x,p.cnt+1));
					visit[x]=true;
				}
			}
		}


	}

}
