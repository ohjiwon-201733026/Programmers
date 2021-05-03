package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {

	public static int [][] tomato;
	public static int M,N;
	public static int [] dx= {1,0,-1,0};
	public static int [] dy= {0,1,0,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();

		tomato=new int[N][M];

		boolean flag=false;

		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				tomato[i][j]=sc.nextInt();

		bfs();

		int max=0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(tomato[i][j]==0) flag=true;
				if(max<tomato[i][j]) max=tomato[i][j];
			}
		}

		System.out.println(flag?"-1":max-1);


	}

	static class Node{
		int i;
		int j;

		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}

	public static void bfs() {
		Queue<Node> q=new LinkedList<>();

		for(int i=0;i<N;++i)
			for(int j=0;j<M;++j)
				if(tomato[i][j]==1) q.add(new Node(i,j));

		while(!q.isEmpty()) {
			Node tmp=q.poll();
			for(int k=0;k<4;++k) {
				int x=tmp.i+dx[k];
				int y=tmp.j+dy[k];
				if(0<=x && x<N && 0<=y && y<M && tomato[x][y]==0) {
					tomato[x][y]=tomato[tmp.i][tmp.j]+1;
					q.add(new Node(x,y));
				}
			}
		}
	}

}
