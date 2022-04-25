package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B3197_백조의호수 {
    static int R,C;
    static Queue<Node> waterQ;
    static Queue<Node> q;
    static Queue<Node> nextQ;
    static char [][] map;
    static Node [] swan;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static boolean [][] visited;
    static class Node{
        int r,c;
        int cnt;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        waterQ = new LinkedList<>();
        q = new LinkedList<>();
        swan = new Node[2];
        map = new char[R][C];
        visited = new boolean[R][C];

        // 데이터 입력
        int swanIdx = 0;
        for(int r = 0 ; r < R ; ++r) {
            char[] line = br.readLine().toCharArray();
            for(int c = 0 ; c < C ; ++c) {
                map[r][c] = line[c];
                if(map[r][c] == 'L') {
                    swan[swanIdx++] = new Node(r, c);
                }
                if(map[r][c] != 'X') {
                    waterQ.offer(new Node(r, c));
                }
            }
        }

        q.add(swan[0]);
        visited[swan[0].r][swan[0].c]=true;

        int day=0;
        boolean meet=false;

        while (true){
            nextQ=new LinkedList<>();

            while (!q.isEmpty()){
                Node now=q.poll();

                if(now.r==swan[1].r && now.c==swan[1].c){
                    meet=true;
                    break;
                }

                for(int k=0;k<4;++k){
                    int nx=now.r+dx[k];
                    int ny=now.c+dy[k];

                    if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny]=true;

                    if(map[nx][ny]=='X') {
                        nextQ.add(new Node(nx,ny)); // 다음에 탐색할 부분
                        continue;
                    }

                    q.add(new Node(nx,ny)); // 현재 탐색(물) 부분
                }

            }

            if(meet) break;
            q=nextQ; // 다음 탐색부분 변경해주기

            int size=waterQ.size();

            for(int i=0;i<size;++i){
                Node now=waterQ.poll();

                for(int k=0;k<4;++k){
                    int nx=now.r+dx[k];
                    int ny=now.c+dy[k];

                    if(nx<0 || nx>=R || ny<0 || ny>=C) continue;

                    if(map[nx][ny]=='X'){
                        map[nx][ny]='.';
                        waterQ.add(new Node(nx,ny));
                    }
                }
            }
            day++;

        }

        System.out.println(day);




    }

}
