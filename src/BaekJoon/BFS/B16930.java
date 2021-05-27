// 달리기 ***
package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16930 {

	public static int N,M,K,x1,x2,y1,y2,cnt;
	public static int [] dx= {0,1,0,-1};
	public static int [] dy= {1,0,-1,0};

	public static class Node{
		int x;
		int y;

		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		char [][] map=new char[N+1][M+1];
		int [][] visit=new int [N+1][M+1];
		for(int i=1;i<=N;++i) {
			String s=sc.next();
			for(int j=1;j<=M;++j) {
				map[i][j]=s.charAt(j-1);
			}
		}

		x1=sc.nextInt();
		y1=sc.nextInt();
		x2=sc.nextInt();
		y2=sc.nextInt();

		Queue<Node> q=new LinkedList<>();
		q.add(new Node(x1,y1));
		visit[x1][y1]=0;
		top:
			while(!q.isEmpty()) {
				Node now=q.poll();
				for(int i=0;i<4;++i) {

					for(int j=1;j<=K;++j) {
						int nx=now.x+dx[i]*j;
						int ny=now.y+dy[i]*j;
						if(0<nx && 0<ny && nx<=N && ny<=M && map[nx][ny]=='.') {
							if(visit[nx][ny]==0) {
								visit[nx][ny]=visit[now.x][now.y]+1;
								if(nx==x2&&ny==y2) break top;
								q.add(new Node(nx,ny));
							}else if(visit[nx][ny]<=visit[now.x][now.y]) { // 더 적은 시간이면 방향 바꾸기
								break;
							}
						}
						else {
							break;
						}
					}
				}
			}
		System.out.println(visit[x2][y2]=visit[x2][y2]==0?-1:visit[x2][y2]);

	}




}
