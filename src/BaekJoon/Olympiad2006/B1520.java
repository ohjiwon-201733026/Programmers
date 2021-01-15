// 내리막길
package BaekJoon.Olympiad2006;

import java.util.Scanner;

public class B1520 {

	public static int [][] graph;
	public static int [][] dp;
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static int N;
	public static int M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		graph=new int [N][M];
		dp=new int [N][M];

		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				graph[i][j]=sc.nextInt();
				dp[i][j]=-1;
			}
		}

		int result=dfs(0,0);
		System.out.println(result);

	}

	public static int dfs(int i, int j) {
		dp[i][j]=0;

		for(int k=0; k<4 ; ++k) {
			int x= i+ dx[k];
			int y= j+ dy[k];

			if(x>=0 && x< N && y>=0 && y< M) {

				if(graph[i][j]>graph[x][y]) {
					if(x==N-1 && y == M-1) dp[i][j]+=1;
				if(dp[x][y]>=0) dp[i][j]+=dp[x][y];
				else dp[i][j]+=dfs(x,y);
			}
			}
		}

		return dp[i][j];
	}

}
