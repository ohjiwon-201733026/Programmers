// 내리막길
package BaekJoon.Olympiad2006;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1520 {

	public static int [][] arr;
	public static int score;
	public static int count;
	public static boolean [][] check;
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static int n;
	public static int m;



	public static class Pair{
		int x;
		int y;

		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}

	}
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(i,j));
		score=arr[i][j];
		check[i][j]=true;

		if(i==n-1&&j==m-1) {
			check=new boolean[n][m];
			count++;
		}

		while(!q.isEmpty()) {
			Pair p=q.remove();

			for(int k=0;k<4;k++) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];
				if(x>=0 && x<n && y>=0 && y<m) {
					System.out.println(arr[x][y]+" "+score);
					if(arr[x][y]<score && !check[x][y]) {
						check[i][j]=true;
						q.add(new Pair(x,y));
						bfs(x,y);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int [n][m];
		check=new boolean [n][m];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		count=0;
		score=arr[0][0];
		check[0][0]=true;
		bfs(0,0);
		System.out.println(count);

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}


	}

}
