// 숨바꼭질 2
package BaekJoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851 {
	public static int cnt=0;
	public static int [] check=new int [100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();

		bfs(N,K);

	}

	private static void bfs(int n, int k) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();

		while(!q.isEmpty()) {
			int p=q.poll();
			if(p==k) {
				System.out.println(check[p]);
				return;
			}

			for(int i=0;i<3;++i) {
				int x=0;
				if(i==0) x=p-1;
				if(i==1) x=p+1;
				else x=2*p;

				if(x>=0 && x<10000 && check[x]==0) {
					q.add(x);
					check[x]=check[p]+1;
				}
			}
		}
		System.out.println(-1);

	}

}
