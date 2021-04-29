// 바이러스
package BaekJoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
	public static int N;
	public static int [][] virus;
	public static boolean [] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int K=sc.nextInt();

		virus=new int[N+1][N+1];
		check=new boolean [N+1];

		for(int i=0;i<K;++i) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			virus[x][y]=1;
			virus[y][x]=1;
		}

		int res=bfs(1);
		System.out.println(res);
	}
	private static int bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		check[i]=true;
		q.add(i);
		int count=0;

		while(!q.isEmpty()) {
			int tmp=q.poll();

			for(int k=1;k<=N;k++) {
				if(virus[tmp][k]==1&&!check[k]) {
					count++;
					check[k]=true;
					q.add(k);
				}
			}
		}

		return count;

	}



}
