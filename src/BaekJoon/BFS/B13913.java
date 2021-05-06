package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B13913 {

	public static int N, K;
	public static boolean[] visit;
	public static int[] parent; // 이전 위치를 저장함

	public static class Pair {
		int x;
		int cnt;

		Pair(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[100001];
		parent = new int[100001];

		bfs(N, K);

		Stack<Integer> stack=new Stack<>();
		stack.push(K);
		int index=K;

		while(index!=N) {
			stack.push(parent[index]);
			index=parent[index];
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}

	}

	private static void bfs(int n, int k) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(n, 0));
		visit[n] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (p.x == k) {
				System.out.println(p.cnt);
				return;
			}
			// 2*x
			if (0 <= 2 * p.x && 2 * p.x <= 100000 && !visit[2 * p.x]) {
				q.offer(new Pair(2 * p.x, p.cnt+1));
				visit[p.x * 2] = true;
				parent[p.x*2]=p.x;
			}
			// x-1
			if (0 <= p.x - 1 && p.x - 1 <= 100000 && !visit[p.x - 1]) {
				q.offer(new Pair(p.x - 1, p.cnt + 1));
				visit[p.x - 1] = true;
				parent[p.x-1]=p.x;
			}
			// x+1
			if (0 <= p.x + 1 && p.x + 1 <= 100000 && !visit[p.x + 1]) {
				q.offer(new Pair(p.x + 1, p.cnt + 1));
				visit[p.x + 1] = true;
				parent[p.x+1]=p.x;
			}
		}

	}

}
