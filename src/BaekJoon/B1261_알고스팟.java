package BaekJoon;

import java.io.*;
import java.util.*;

public class B1261_알고스팟 {
    public static int M, N;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        System.out.println(bfs(0, 0));


    }

    static class Node implements Comparable<Node> {
        int x, y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }

    static int bfs(int i, int j) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(i, j, 0));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();


            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cnt;
            }

            for (int k = 0; k < 4; ++k) {
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];

                if (0 <= x && x < N && 0 <= y && y < M && !visited[x][y]) {
                    if (map[x][y] == 1) q.add(new Node(x, y, cur.cnt + 1));
                    else q.add(new Node(x, y, cur.cnt));
                    visited[x][y] = true;

                }
            }
        }
        return 0;
    }
}
