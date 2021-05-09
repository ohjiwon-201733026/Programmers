package Programmers.Kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kakao20210508_2 {
	public static int [] dx= {0,-1,0,1};
	public static int [] dy= {-1,0,1,0};
	public static char [][] arr=new char[5][5];
	public static int [][] visit;
	public static boolean flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String [] tmp= {
				"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"
		};

		for(int i=0;i<5;++i) {
			String s=tmp[i];
			for(int j=0;j<5;++j) {
				arr[i][j]=s.charAt(j);
			}
		}

		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				if(arr[i][j]=='P') {
					visit=new int [5][5];
					bfs(i,j);
				}
			}
		}

		System.out.println(flag);



	}

	public static class Node{
		int x;
		int y;

		public Node(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));
		visit[i][j]=1;

		while(!q.isEmpty()) {
			Node p=q.poll();

			for(int k=0;k<4;++k) {
				int x= p.x+dx[k];
				int y= p.y+dy[k];

				if(x>=0 && x<5 && y>=0 && y<5) {
					if(arr[x][y]=='O') {
						visit[x][y]=visit[p.x][p.y]+1;
					}
					if(arr[x][y]=='X')
						visit[x][y]=4;
					if(arr[x][y]=='P') {
						visit[x][y]=visit[p.x][p.y]+1;
						flag=false;
					}

					q.add(new Node(x,y));
				}
			}
		}

	}

}
