package BaekJoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {

	public static int [][] graph;
	public static boolean [] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); // 정점개수
		int M=sc.nextInt(); // 간선 개수
		int V=sc.nextInt(); // 탐색 시작할 정점

		graph=new int [N+1][N+1];
		visited=new boolean[N+1];

		for(int i=0;i<M;++i) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			graph[a][b]=1;
			graph[b][a]=1;
		}
		dfs(V);
		for(int i=0;i<=N;++i) visited[i]=false;
		System.out.println();
		bfs(V);

	}

	private static void dfs(int v) {
		// TODO Auto-generated method stub

		if(visited[v]) return;
		visited[v]=true;
		System.out.print(v+" ");
		for(int i=0;i<graph.length;++i) {
			if(graph[v][i]==1) dfs(i);
		}

	}

	private static void bfs(int v) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		q.add(v);
		visited[v]=true;
		while(!q.isEmpty()) {
			int x=q.poll();
			System.out.print(x+" ");
			for(int i=0;i<graph.length;++i) {
				if(!visited[i]&&graph[x][i]==1) {
					visited[i]=true;
					q.add(i);
				}
			}
		}

	}

}
