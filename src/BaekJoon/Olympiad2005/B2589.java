// 보물섬
package BaekJoon.Olympiad2005;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2589 {
	public final static int[] dx= {1,0,-1,0};
	public final static int[] dy= {0,1,0,-1};
	public static char[][] array;
	public static boolean [][] check;
	public static int count=0;
	public static int n,m;


	public static class Pair{
		int x;
		int y;
		int cnt;

		public Pair(int x,int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}

	public static int bfs(int i, int j) {

		Queue<Pair> q=new LinkedList<>();
		int val=0;
		check[i][j]=true;
		q.add(new Pair(i,j,0));

		while(!q.isEmpty()) {
			Pair p=q.poll();
			for(int k=0;k<4;k++) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];
				if(0<=x&&x<n&&0<=y&&y<m&&!check[x][y]&&array[x][y]=='L') {
					check[x][y]=true;
					q.add(new Pair(x,y,p.cnt+1));
					val=Math.max(val, p.cnt+1);
				}
			}


		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		array=new char[n][m];
		check=new boolean[n][m];

		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<m;j++)
				array[i][j]=s.charAt(j);
		}

		int result=0;
		for(int i=0;i<n;i++) { // 육지(L)인 부분 중에서 다 bfs 값 알아와 최대값 구하기
			for(int j=0;j<m;j++) {
				if(array[i][j]=='L') {
					check=new boolean[n][m]; // 매번 새로 초기화 시켜야한다!!!!!!!!
					int val=bfs(i,j);
					result=Math.max(result, val);
				}
			}
		}

		System.out.println(result);

//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(array[i][j]);
//			}
//			System.out.println();
//		}

	}

}
