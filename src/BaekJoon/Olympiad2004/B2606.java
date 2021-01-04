// 바이러스
package BaekJoon.Olympiad2004;

import java.util.Scanner;

public class B2606 {
	static int count=0;
	static boolean check[];
	public static void dfs(int [][] conn,int start) {

		if(check[start]==true) return; // 이게 문제

		count++;
		check[start]=true;

		for(int i=0;i<conn.length;i++) {

			if(conn[start][i]==1&&!check[i]) {

				dfs(conn,i);
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][] conn=new int [n+1][n+1];
		check=new boolean[n+1];
		for(int i=0;i<n;i++) {
			check[i]=false;
		}
		int connNum=sc.nextInt();
		for(int i=0;i<connNum;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			conn[x][y]=1;
			conn[y][x]=1;
		}
		dfs(conn,1);
		System.out.println(count-1);

	}

}
