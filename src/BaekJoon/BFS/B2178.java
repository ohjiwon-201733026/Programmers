package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
	public static int N,M;
	public static int [][] map;
	public static boolean [][] visit;
	public static final int [] dx= {0,1,-1,0};
	public static final int [] dy= {1,0,0,-1};

	public static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); // 4
		M=sc.nextInt(); // 6

		map=new int [N+1][M+1];
		visit=new boolean [N+1][M+1];

		for(int i=0;i<N;++i) {
			String s=sc.next();
			for(int j=0;j<M;++j) {
				map[i+1][j+1]=s.charAt(j)-'0';
			}
		}

		visit[1][1]=true;
		bfs(1,1);
		System.out.println(map[N][M]);

		for(int i=0;i<=N;++i) {
			for(int j=0;j<=M;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static void bfs(int i, int j) {
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(i,j));

		while(!q.isEmpty()) {
			Point p=q.poll();
			System.out.println(p.x+" "+p.y);
			for(int k=0;k<4;++k) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];

				if(x<=0 || y<=0 || x>N || y<=M) continue;
				if( visit[x][y] || map[x][y]==0) continue;

				q.add(new Point(x,y));
				map[x][y]=map[p.x][p.y]+1;
				visit[x][y]=true;

			}
		}
	}

}
