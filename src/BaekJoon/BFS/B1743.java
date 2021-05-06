package BaekJoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1743 {

	public static int N,M;
	public static int [][] map;
	public static boolean [][] check;
	public static final int [] dx= {0,1,-1,0};
	public static final int [] dy= {1,0,0,-1};
	public static ArrayList<Integer> al=new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int K=sc.nextInt();

		map=new int[N+1][M+1];
		check=new boolean [N+1][M+1];
		for(int i=0;i<K;++i) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			map[x][y]=1;
		}

		for(int i=0;i<=N;++i) {
			for(int j=0;j<=M;++j) {
				if(map[i][j]==1 && !check[i][j]) {
					bfs(i,j);
				}
			}
		}

		Collections.sort(al);
		System.out.println(al.get(al.size()-1));

	}
	public static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

	public static void bfs(int i, int j) {
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(i,j));
		check[i][j]=true;
		int count=1;

		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int k=0;k<4;++k) {
				int x= p.x+dx[k];
				int y=p.y+dy[k];

				if(0<x&& x<=N && 0<y && y<=M) {
					if(map[x][y]==1&&!check[x][y]) {
						count++;
						q.add(new Point(x,y));
						check[x][y]=true;
					}
				}
			}
		}

		al.add(count);

	}

}
