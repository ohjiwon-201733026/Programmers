// 미로탐색
package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
	private static int n, m;
	private static char [][] arr;
	private static boolean [][] visit;
	private static int [][] dist;
	public final static int[] dx= {1,0,-1,0};
	public final static int[] dy= {0,1,0,-1};

	private static class Point{
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> q=new LinkedList<>();

		q.add(new Point(i,j,0));
		visit[i][j]=true;
		dist[i][j]=1;

		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int k=0;k<4;k++) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];
				if(0<=x&&x<n&&0<=y&&y<m&&!visit[x][y]&&arr[x][y]=='1') {
					visit[x][y]=true;
					dist[x][y]=dist[p.x][p.y]+1;
					q.add(new Point(x,y,p.cnt+1));

				}
			}
		}



	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new char[n][m];
		visit=new boolean[n][m];
		dist=new int[n][m];

		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<m;j++) {
				arr[i][j]=s.charAt(j);
			}
		}

		bfs(0,0);
		System.out.println(dist[n-1][m-1]);



	}

}
