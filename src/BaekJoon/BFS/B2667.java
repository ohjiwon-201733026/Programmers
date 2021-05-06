package BaekJoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2667 {
	static boolean [][] visited;
	static int [][] graph;
	static int [] dx= {1,0,0,-1};
	static int [] dy= {0,1,-1,0};
	static int N;
	static ArrayList<Integer> al;

	static class Node{
		int i;
		int j;

		public Node(int i, int j) {
			// TODO Auto-generated constructor stub
			this.i=i;
			this.j=j;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		visited=new boolean [N][N];
		graph=new int [N][N];
		int num=0;
		al=new ArrayList<>();

		for(int i=0;i<N;++i) {
			String s=sc.next();
			for(int j=0;j<s.length();++j)
				graph[i][j]=s.charAt(j)-'0';
		}


		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(graph[i][j]==1&&!visited[i][j]) {
					dfs(i,j);
					num++;
				}
			}
		}

		System.out.println(num);
		Collections.sort(al);

		for(int i=0;i<al.size();++i) {
			System.out.println(al.get(i));
		}


	}

	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));
		visited[i][j]=true;
		int count=1;

		while(!q.isEmpty()) {
			Node tmp=q.poll();
			for(int k=0;k<4;++k) {
				int x=tmp.i+dx[k];
				int y=tmp.j+dy[k];
				if(0<=x && x<N && 0<=y && y<N && !visited[x][y] && graph[x][y]==1) {
					visited[x][y]=true;
					q.add(new Node(x,y));
					count++;
				}
			}
		}

		al.add(count);


		}

}
