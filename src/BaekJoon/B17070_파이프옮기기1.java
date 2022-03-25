package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17070_파이프옮기기1 {

    static int n;
    static int [][] map;
    static boolean [][][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int [n][n];
        visited=new boolean[n][n][3];

        for(int i=0;i<n;++i){
            String [] s=br.readLine().split(" ");
            for(int j=0;j<n;++j){
                map[i][j]=Integer.parseInt(s[j]);
            }
        }
        answer=0;
        bfs(0,0,0);
        System.out.println(answer);

    }

    static void bfs(int i, int j,int d){
        Queue<Pipe> q=new LinkedList<>();
        q.add(new Pipe(i,j,d,0));
//        visited[i][j][d]=true;

        while (!q.isEmpty()){
            Pipe cur=q.poll();
//            visited[cur.x][cur.y][cur.dir]=true;
//            System.out.println(cur.toString());

            // 리턴 조건
            if(cur.dir==0 && cur.x==n-1 && cur.y==n-2){
                answer++;
                continue;
            }
            if(cur.dir==1 && cur.x==n-2 && cur.y==n-1){
                answer++;
                continue;
            }
            if(cur.dir==2 && cur.x==n-2 && cur.y==n-2){
                answer++;
                continue;
            }

            int x=cur.x;
            int y= cur.y;
            int cnt= cur.cnt;

            // 이동
            // 가로
            if(cur.dir==0){
                if(check(x,y+2)){
                    q.add(new Pipe(x,y+1,0,cnt+1));
                }

                if(check(x,y+2) && check(x+1,y+1) && check(x+1,y+2)){
                    q.add(new Pipe(x,y+1,2,cnt+1));
                }
            }

            // 세로
            if(cur.dir==1){
                if(check(x+2,y)){
                    q.add(new Pipe(x+1,y,1,cnt+1));
                }
                if(check(x+1,y+1) && check(x+2,y) && check(x+2,y+1)){
                    q.add(new Pipe(x+1,y,2,cnt+1));
                }
            }

            // 대각선
            if(cur.dir==2){
                if(check(x+1,y+2)){
                    q.add(new Pipe(x+1,y+1,0,cnt+1));
                }

                if(check(x+2,y+1)){
                    q.add(new Pipe(x+1,y+1,1,cnt+1));
                }

                if(check(x+1,y+2) && check(x+2,y+1) && check(x+2,y+2)){
                    q.add(new Pipe(x+1,y+1,2,cnt+1));
                }
            }
        }
    }

    static boolean check(int x, int y){
        return 0<=x && x<n && 0<=y && y<n && map[x][y]==0;
    }

    static class Pipe{
        int x,y;
        int dir;
        int cnt;

        public Pipe(int x, int y, int dir,int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt=cnt;
        }

        @Override
        public String toString() {
            return "Pipe{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
