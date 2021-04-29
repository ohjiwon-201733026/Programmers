package BaekJoon.Graph;

import java.util.HashMap;
import java.util.Scanner;

public class B1303_dfs {

	public static int N,M;
	public static char [][] map;
	public static HashMap<Character,Integer> hm;
	public static int [] dx= {1,0,-1,0};
	public static int [] dy= {0,1,0,-1};
	public static boolean [][] visit;
	public static int w,b;
	public static int countW, countB;

	public static class Node{
		int i;
		int j;

		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int M=sc.nextInt();

		map=new char[M][N];
		visit=new boolean[M][N];


		for(int i=0;i<M;i++) {
			String s=sc.next();
			for(int j=0;j<N;++j) {
				map[i][j]=s.charAt(j);
			}
		}

		for(int i=0;i<M;i++) {
			for(int j=0;j<N;++j) {
				if(map[i][j]=='W'&&!visit[i][j]) {
					dfs(i,j,'W');
					countW= countW+w*w;
				}

				if(map[i][j]=='B'&&!visit[i][j]) {
					dfs(i,j,'B');
					countB=countB+b*b;
				}
			}
		}

		System.out.println(countW+" "+countB);
	}


	private static void dfs(int i, int j, char c) {
		if(visit[i][j]) return;
		for(int k=0;k<4;++k) {
			int x=i+dx[k];
			int y=j+dy[k];

			if(0<=x && x<M && 0<=y && y<N && map[x][y]==c && !visit[x][y]) {
				visit[x][y]=true;
				if(c=='W') w++;
				else b++;
				dfs(x,y,c);

			}
		}

	}

}
