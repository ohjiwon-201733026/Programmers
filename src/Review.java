
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {
	static int [][] map;
	static int N,M;
	static int [] dx= {0,1,0,-1};
	static int [] dy= {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();

		map=new int [N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
			}
		}


		bfs();
		boolean flag=false;
		int max=0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==0) flag=true;
				if(max<map[i][j]) max=map[i][j];
			}
		}


		System.out.println(flag?"-1":max-1);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Point> q=new LinkedList<>();
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==1) {
					q.add(new Point(i,j));
				}
			}
		}

		while(!q.isEmpty()) {
			Point p=q.poll();

			for(int k=0;k<4;++k) {
				int x=p.x+ dx[k];
				int y=p.y+ dy[k];

				if(0<=x && x< N && 0<=y && y<M) {
					if(map[x][y]==0) {
						q.add(new Point(x,y));
						map[x][y]=map[p.x][p.y]+1;
					}
				}
			}
		}

	}

	public static class Point{
		int x;
		int y;

		Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
