package BaekJoon.BFS;

import java.util.Scanner;

public class B14502_연구소 {
	public static int N, M;			// 지도 크기
	public static int map[][];		// 지도
	public static int virusMap[][];	// 지도 복사본
	public static int max = 0;		// 최대 영역갯수
	public static int[] dx = {0, -1, 0, 1};	// 동북남서 방향
	public static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		map=new int [N][M];

		// 입력
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
			}
		}

		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(1);
					map[i][j]=0;
				}
			}
		}


	}
	private static void dfs(int count) {
		// TODO Auto-generated method stub
		if(count==3) {
			bfs();
			return;
		}

		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(count+1);
					map[i][j]=0;
				}
			}
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		virusMap=new int [N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				virusMap[i][j]=map[i][j];
			}
		}


	}

}
