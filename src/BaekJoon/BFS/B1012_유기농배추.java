package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1012_유기농배추 {
	public static boolean [][] visit;
	public static int [] dx= {0,-1,0,1};
	public static int [] dy= {-1,0,1,0};
	public static int cnt;
	public static int N,M;
	public static int [][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		while(T-->0) {
			String [] a=br.readLine().split(" ");
			M=Integer.parseInt(a[0]); // 가로길이
			N=Integer.parseInt(a[1]); // 세로길이
			int K=Integer.parseInt(a[2]); // 배추
			cnt=0;

			map=new int [M][N];
			visit=new boolean[M][N];
			for(int i=0;i<K;++i) {
				String [] b=br.readLine().split(" ");
				int x= Integer.parseInt(b[0]);
				int y= Integer.parseInt(b[1]);
				map[x][y]=1;
			}

			for(int i=0;i<M;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==1 && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}
	private static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));
		visit[i][j]=true;

		while(!q.isEmpty()) {
			Node p=q.poll();
			for(int k=0;k<4;++k) {
				int x= p.x+dx[k];
				int y= p.y+dy[k];
				if(0<=x && x<M && 0<=y && y<N) {
					if(map[x][y]==1 && !visit[x][y]) {
						q.add(new Node(x,y));
						visit[x][y]=true;
					}
				}

			}
		}

	}

}
