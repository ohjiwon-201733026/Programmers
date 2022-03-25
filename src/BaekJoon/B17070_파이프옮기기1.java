package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
        dfs(0,0,0);
        System.out.println(answer);

    }
    static void dfs(int i, int j, int dir){
        // 리턴 조건
        if(dir==0 && i==n-1 && j==n-2){
            answer++;
            return;
        }
        if(dir==1 && i==n-2 && j==n-1){
            answer++;
            return;
        }
        if(dir==2 && i==n-2 && j==n-2){
            answer++;
            return;
        }

        int x=i;
        int y=j;

        // 이동
        // 가로
        if(dir==0){
            if(check(x,y+2)){
                dfs(x,y+1,0);
            }

            if(check(x,y+2) && check(x+1,y+1) && check(x+1,y+2)){
                dfs(x,y+1,2);
            }
        }

        // 세로
        if(dir==1){
            if(check(x+2,y)){
                dfs(x+1,y,1);
            }
            if(check(x+1,y+1) && check(x+2,y) && check(x+2,y+1)){
                dfs(x+1,y,2);
            }
        }

        // 대각선
        if(dir==2){
            if(check(x+1,y+2)){
                dfs(x+1,y+1,0);
            }

            if(check(x+2,y+1)){
                dfs(x+1,y+1,1);
            }

            if(check(x+1,y+2) && check(x+2,y+1) && check(x+2,y+2)){
                dfs(x+1,y+1,2);
            }
        }

    }

    static void bfs(int i, int j,int d){
        Queue<Pipe> q=new LinkedList<>();
        q.add(new Pipe(i,j,d,0));

        while (!q.isEmpty()){
            Pipe cur=q.poll();



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
