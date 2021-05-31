package BaekJoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1325_효율적인해킹 {
	public static int[] parent;
	public static boolean[] visit;
	public static ArrayList<Integer>[] al;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N + 1];
		al = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			al[sc.nextInt()].add(sc.nextInt());
		}

		for (int i = 1; i <= N; ++i) {
			visit = new boolean[N + 1];
			bfs(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, parent[i]);
		}
		for (int i = 1; i <= N; i++) {
			if (parent[i] == max)
				System.out.print(i+" ");
		}

	}

	private static void bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visit[i] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int x : al[cur]) {
				if (!visit[x]) {
					visit[x] = true;
					parent[x]++;
					q.add(x);
				}
			}
		}
	}

}
