package BaekJoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13549 {

	public static int N, K;
	public static boolean[] visit;

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

		bfs(N, K);

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
				q.offer(new Pair(2 * p.x, p.cnt));
				visit[p.x * 2] = true;
			}
			// x-1
			if (0 <= p.x - 1 && p.x - 1 <= 100000 && !visit[p.x - 1]) {
				q.offer(new Pair(p.x - 1, p.cnt + 1));
				visit[p.x - 1] = true;
			}
			// x+1
			if (0 <= p.x + 1 && p.x + 1 <= 100000 && !visit[p.x + 1]) {
				q.offer(new Pair(p.x + 1, p.cnt + 1));
				visit[p.x + 1] = true;
			}

		}

	}

}
