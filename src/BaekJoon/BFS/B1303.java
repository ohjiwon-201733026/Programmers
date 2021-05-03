// 전쟁-전투
package BaekJoon.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1303 {

	public static int N,M;
	public static char [][] map;
	public static HashMap<Character,Integer> hm;
	public static int [] dx= {1,0,-1,0};
	public static int [] dy= {0,1,0,-1};
	public static boolean [][] visit;


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

		N=sc.nextInt();
		M=sc.nextInt();

		map=new char[M][N];
		visit=new boolean[M][N];


		for(int i=0;i<M;i++) {
			String s=sc.next();
			for(int j=0;j<N;++j) {
				map[i][j]=s.charAt(j);
			}
		}

		hm=new HashMap<>();
		hm.put('B', 0);
		hm.put('W', 0);

		for(int i=0;i<M;i++) {
			for(int j=0;j<N;++j) {
				if(!visit[i][j]) {
					bfs(i,j);

				}
			}
		}
		System.out.print(hm.get('W')+" ");
		System.out.println(hm.get('B'));


	}


	private static void bfs(int i, int j) {
		Queue<Node> q=new LinkedList<>();;
		int count=1;
		visit[i][j]=true;
		q.add(new Node(i,j));
		char team=map[i][j];

		while(!q.isEmpty()) {
			Node tmp=q.poll();
			for(int k=0;k<4;++k) {
				int x=tmp.i+dx[k];
				int y=tmp.j+dy[k];
				if(0<=x && x<M && 0<=y && y<N && map[x][y]==team&& !visit[x][y]) {
					count++;
					visit[x][y]=true;
					q.add(new Node(x,y));
				}
			}
		}
		hm.put(team, hm.get(team)+ count*count);
	}

}
