// BFS로 풀기
package BaekJoon.DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1463_1로만들기 {
	public static int [] dp;
	public static boolean[] visit;
	public static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp=new int [N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		bfs(N);

	}



	private static void bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		dp[i]=0;

		while (!q.isEmpty()) {
			int p = q.poll();
			if(p<1) continue;

			if(p%3==0) {
				if(dp[p/3]>dp[p]+1) {
					dp[p/3]=dp[p]+1;
					q.add(p/3);
				}
			}
			if(p%2==0) {
				if(dp[p/2]>dp[p]+1) {
					dp[p/2]=dp[p]+1;
					q.add(p/2);
				}
			}

				if(dp[p-1]>dp[p]+1) {
					dp[p-1]=dp[p]+1;
					q.add(p-1);
				}
			}
		System.out.println(dp[1]);
	}

}
