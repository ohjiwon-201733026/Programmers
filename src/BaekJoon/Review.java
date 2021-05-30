package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Review {

	public static int[][] arr;
	public static boolean[][] visit;
	public static int N, M;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };

	public static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		visit = new boolean[N][M];


		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 토마토 있는 곳 모두 queue에 넣기
		Queue<Node> q = new LinkedList<>();
		for (int l = 0; l < N; ++l) {
			for (int k = 0; k < M; ++k) {
				if (arr[l][k] == 1 && !visit[l][k]) {
					q.add(new Node(l, k));
					visit[l][k] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Node p = q.poll();

			for (int t = 0; t < 4; ++t) {
				int x = p.i + dx[t];
				int y = p.j + dy[t];

				if (0 <= x && x < N && 0 <= y && y < M && !visit[x][y] && arr[x][y] == 0) {
					arr[x][y] = arr[p.i][p.j] + 1;
					q.add(new Node(x, y));
					visit[x][y] = true;
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
