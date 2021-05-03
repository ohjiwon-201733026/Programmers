// 아기상어2
package BaekJoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17086 {
	public static int [][] shark;
	public static boolean [][] visit;
	public static ArrayList<Integer> list= new ArrayList<>();;
	public static int [] dx= {0,1,1,1,0,-1,-1,-1};
	public static int [] dy= {1,1,0,-1,-1,-1,0,1};
	public static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		shark=new int [N][M];
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				shark[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(shark[i][j]==0) {
					bfs(i,j);
				}
			}
		}	
		int max=0;
		for(int x: list) max=max<x?x:max;
		System.out.println(max);
		
	}
	public static class Node{
		int i;
		int j;
		int cnt;
		
		Node(int i, int j, int cnt){
			this.i=i;
			this.j=j;
			this.cnt=cnt;
		}
	}
	
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		visit=new boolean [N][M];
		q.add(new Node(i,j,0));
		visit[i][j]=true;
		
		while(!q.isEmpty()) {
			Node cur=q.poll();
			
			for(int k=0;k<8;++k) {
				int x=cur.i+dx[k];
				int y=cur.j+dy[k];
				int d=cur.cnt;
				
				if(0<=x && x<N && 0<=y && y<M && !visit[x][y] && shark[x][y]==1) {
					list.add(d+1);
					return;
				}
				
				if(0<=x && x<N && 0<=y && y<M && !visit[x][y] && shark[x][y]==0) {
					q.add(new Node(x,y,d+1));
					visit[x][y]=true;
				}
					
			}
			
			
		}
		
	}

}
