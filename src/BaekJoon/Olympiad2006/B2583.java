// 영역 구하기
package BaekJoon.Olympiad2006;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class B2583 {

	public static int check[][];
	public static int N;
	public static int M;
	public static int count=0;
	public static int squareCount=0;
	public static int [] dx= {1,0,-1,0};
	public static int [] dy= {0,1,0,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); // row
		M=sc.nextInt(); // col
		check=new int[N][M]; // 사각형 표시할 배열
		Vector<Integer> v=new Vector<>();

		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			square(x1,y1,x2,y2);
		}


		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(check[i][j]==0) {
					count++;
					squareCount=0;
					bfs(i,j);
					v.add(squareCount+1);
				}
			}
		}

		Collections.sort(v);
		for(int i=0;i<v.size();i++) {
			System.out.print(v.get(i)+" ");
		}


		System.out.println();
		System.out.println(count);

	}

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
		check[i][j]=1;
		q.add(new Pair(i,j));

		while(!q.isEmpty()) {
			Pair p=q.poll();

			for(int k=0;k<4;k++) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];
				if(x>=0 && x<N && y>=0 && y<M) {
					if(check[x][y]==0) {
						check[x][y]=1;
						++squareCount;
						bfs(x,y);
					}
				}
			}
		}

	}

	private static void square(int x1, int y1, int x2, int y2) {  // 직사각형 범위 표시

		for(int i=x1;i<x2;i++) {
			for(int j= y1; j< y2; j++)
				check[j][i]=1;
		}
	}

}
