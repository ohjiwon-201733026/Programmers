package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B3197_백조의호수 {
    static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Node> q;
    static Queue<Node> waterQ;
    static int [][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    static char [][] map;
    static boolean [][] visited;
    static Node[] swan;
    static int R,C;

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
                    swan[swanIdx++] = new Node(r, c); // 백조 위치 따로 저장
                }
                if(map[r][c] != 'X') {
                    waterQ.offer(new Node(r, c)); // 모든 물은 waterQ에 저장
                }
            }
        }
        q.offer(swan[0]); // 첫번째 백조 넣고
        visited[swan[0].r][swan[0].c]=true; // 방문 체크

        int day=0;
        boolean meet=false;

        while (true){
            Queue<Node> nextQ=new LinkedList<>();

            // 탐색 큐 BFS 탐색 실시
           while (!q.isEmpty()){
                Node now=q.poll();

                // 백조 만날 시 종료
                if(now.r==swan[1].r && now.c==swan[1].c){
                    meet=true;
                    break;
                }

                for(int d=0;d<4;++d){
                    int nr=now.r+dir[d][0];
                    int nc=now.c+dir[d][1];

                    if(nr>=R || nr<0 || nc>=C || nc<0 || visited[nr][nc]) continue;

                    visited[nr][nc]=true; // 방문 체크

                    if(map[nr][nc]=='X'){ // 다음 큐에 다음날 얼음이 녹아 다음날 탐색 시작점 넣기
                        nextQ.offer(new Node(nr,nc));
                        continue;
                    }

                    // 현재 탐색 가능한 지역(물)
                    q.offer(new Node(nr,nc));
                }
            }

            if(meet) break; // 만났으면 끝내기
            q=nextQ; // 다음 탐색 시작점 바꾸기

            int size=waterQ.size();

            for(int i=0;i<size;++i){ // waterQ에 물과 인접한 얼음 녹이고 그 지점 다시 워터 큐에 넣기
                Node now=waterQ.poll();

                for(int d=0;d<4;++d){
                    int nr=now.r+dir[d][0];
                    int nc=now.c+dir[d][1];

                    if(nr>=R || nr<0 || nc>=C || nc<0) continue;

                    // 물에 인접한 얼음을 발견하면 녹이고 다시 큐에 넣는다
                    if(map[nr][nc]=='X'){
                        map[nr][nc]='.';
                        waterQ.offer(new Node(nr,nc));
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }

}
