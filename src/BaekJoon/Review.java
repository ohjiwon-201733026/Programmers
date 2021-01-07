package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {
	private static int n,m;
	private static boolean [][] visit;
	private static char [][] map;
	private static int [] dx= {1,0,-1,0};
	private static int [] dy= {0,1,0,-1};

	private static class Point{
		int x;
		int y;
		int cnt;

		public Point(int x, int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}

	}



	private static int bfs(int i, int j) {
		// TODO Auto-generated method stub
		int val=0;
		visit[i][j]=true;
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(i,j,0));

		while(!q.isEmpty()) {
			Point p=q.poll();
		for(int k=0;k<4;k++) {
			int x=p.x+dx[k];
			int y=p.y+dy[k];
			if(0<=x&&x<n&&0<=y&&y<m&&!visit[x][y]&&map[x][y]=='L') {
				visit[x][y]=true;
				q.add(new Point(x,y,p.cnt+1));
				val=Math.max(val, p.cnt+1);

			}
		}
		}


		return val;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new char[n][m];


		for(int i=0;i<n;i++)
		{
			String s=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j);
			}
		}


		int val=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='L') {
					visit=new boolean[n][m];
					int c=bfs(i,j);
					val=Math.max(val, c);
				}

			}
		}


		System.out.println(val);


	}

}
