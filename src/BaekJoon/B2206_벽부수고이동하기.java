package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        char[][] arr = new char[N][M];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                arr[i][j] = s.charAt(j);
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][2];
        q.add(new Node(0, 0, 1, false));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.i == N - 1 && node.j == M - 1) {
                System.out.println(node.d);
                return;
            }

            for (int k = 0; k < 4; ++k) {
                int x = node.i + dx[k];
                int y = node.j + dy[k];

                if (0 > x || x >= N || 0 > y || y >= M) continue;

                if (arr[x][y] == '0') {
                    if (!node.flag && !visit[x][y][0]) {
                        q.add(new Node(x, y, node.d + 1, false));
                        visit[x][y][0] = true;
                    } else if(node.flag && !visit[x][y][1]) {
                        q.add(new Node(x, y, node.d + 1, true));
                        visit[x][y][1] = true;
                    }
                }
                if (arr[x][y] == '1' && !node.flag) {
                    q.add(new Node(x, y, node.d + 1, true));
                    visit[x][y][1] = true;
                }
            }
        }
        System.out.println(-1);
    }

    public static class Node{
        int i,j,d;
        boolean flag;

        public Node(int i, int j, int d, boolean flag) {
            this.i = i;
            this.j = j;
            this.d = d;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    ", d=" + d +
                    ", flag=" + flag +
                    '}';
        }
    }

}
