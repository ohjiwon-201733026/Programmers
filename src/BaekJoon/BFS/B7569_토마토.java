package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569_토마토 {

	static int[][][] map;
	static int N, M, H;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][N][M];

		for (int h = 0; h < H; ++h) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					map[h][i][j] = sc.nextInt();
				}
			}
		}

		bfs();
		int max = 0;
		boolean flag = false;
		for (int h = 0; h < H; ++h) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[h][i][j] == 0)
						flag = true;
					if (map[h][i][j]> max)
						max = map[h][i][j];
				}
			}
		}

		System.out.println(flag?-1:max-1);

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<>();
		for (int h = 0; h < H; ++h) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[h][i][j] == 1)
						q.add(new Point(i, j, h));
				}
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 4; ++k) { // 오,왼,앞,뒤
				int x = p.x + dx[k];
				int y = p.y + dy[k];

				if (0 <= x && x < N && 0 <= y && y < M) {
					if (map[p.h][x][y] == 0) {
						q.add(new Point(x, y, p.h));
						map[p.h][x][y] = map[p.h][p.x][p.y] + 1;
					}
				}
			}

			if (p.h - 1 >= 0 && map[p.h - 1][p.x][p.y] == 0) { // 아래
				q.add(new Point(p.x, p.y, p.h - 1));
				map[p.h - 1][p.x][p.y] = map[p.h][p.x][p.y] + 1;
			}

			if (p.h + 1 < H && map[p.h + 1][p.x][p.y] == 0) { // 위
				q.add(new Point(p.x, p.y, p.h + 1));
				map[p.h + 1][p.x][p.y] = map[p.h][p.x][p.y] + 1;
			}
		}

	}

	public static class Point {
		int x;
		int y;
		int h;

		Point(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}
