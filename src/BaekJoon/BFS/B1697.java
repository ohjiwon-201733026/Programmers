package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {

	public static int N;
	public static int K;
	static int [] visit=new int [100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();

		bfs();

	}

	public static void bfs() {
		Queue<Integer> q=new LinkedList<>();
		q.add(N);
		visit[N]=1;

		while(!q.isEmpty()) {
			N=q.poll();
			if(N==K) break;

			if(N+1<=100000 && visit[N+1]==0) {
				q.add(N+1);
				visit[N+1]=visit[N]+1;
			}

			if(N-1>=0&&visit[N-1]==0) {
				q.add(N-1);
				visit[N-1]=visit[N]+1;
			}

			if(N*2<=100000 && visit[N*2]==0) {
				q.add(N*2);
				visit[N*2]=visit[N]+1;
			}
		}

		System.out.println(visit[K]-1);

	}

}
