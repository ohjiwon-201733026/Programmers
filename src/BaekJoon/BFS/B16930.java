// 달리기 ***
package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16930 {
	
	public static int N,M,K,x1,x2,y1,y2,cnt;
	public static char [][] arr;
	public static int [][] visit;
	public static int [] dx= {0,1,0,-1};
	public static int [] dy= {1,0,-1,0};
	
	static class Node{
		int i;
		int j;
		int cnt;
		
		Node(int i,int j,int cnt){
			this.i=i;
			this.j=j;
			this.cnt=cnt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		arr=new char [N][M];
		visit=new int [N][M];
		for(int i=0;i<N;++i) {
			String s=sc.next();
			for(int j=0;j<M;++j) {
				arr[i][j]=s.charAt(j);
			}
		}
		x1=sc.nextInt()-1; y1=sc.nextInt()-1;
		x2=sc.nextInt()-1; y2=sc.nextInt()-1;
		
		System.out.println(bfs(x1,y1));

	}
	

	private static int bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j,0));
		visit[i][j]=0;
		cnt=0;
		while(!q.isEmpty()) {
			Node cur=q.poll();
			
			if(cur.i==x2&&cur.j==y2) return cur.cnt; // 도착지에 오면 count 리턴 
			
			for(int k=0;k<4;++k) { // 위,아래,오른,왼쪽
				for(int r=0;r<K;++r) { // 최대 K초까지 반복
					int x=cur.i+dx[k]*k;
					int y=cur.j+dy[k]*k;
					if(0<=x && x<N && 0<=y && y<M && visit[x][y]==0 && arr[x][y]=='.') {
						visit[x][y]=visit[cur.i][cur.j]+1;
					}
				}
			}
		}
		return -1; // 도착할 수 없는 경우 -1 리턴
		
	}

}
