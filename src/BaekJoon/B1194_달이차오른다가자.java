package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1194_달이차오른다가자 {

    static int N,M;
    static char [][] map;
    static boolean [][][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        map=new char[N][M];
        visited=new boolean[N][M][65];

        int x=0,y=0;

        for(int i=0;i<N;++i){
            String s=sc.next();
            for(int j=0;j<M;++j){
                map[i][j]=s.charAt(j);
                if(map[i][j]=='0') {
                    x=i;y=j;
                }
            }
        }

        bfs(x,y);


    }

    static void bfs(int x, int y){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,y,0,0));
        visited[x][y][0]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();

            if(map[cur.x][cur.y]=='1'){
                System.out.println(cur.cnt);
                return;
            }

            for(int k=0;k<4;++k){
                int nx=cur.x+dx[k];
                int ny=cur.y+dy[k];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny]=='#') continue;

                if(map[nx][ny]-'a'>=0 && map[nx][ny]-'a'<6){ // 열쇠인 경우
                    int key=(1<<(map[nx][ny]-'a')) | cur.key;
                    if(!visited[nx][ny][key]){
                        q.add(new Node(nx,ny, cur.cnt+1,key));
                        visited[nx][ny][key]=true;
                    }
                }
                else if(map[nx][ny]-'A'>=0 && map[nx][ny]-'A'<6 && !visited[nx][ny][cur.key]){ // 문인 경우
                    int key=(1<<(map[nx][ny]-'A')) & cur.key;
                    if(key>0){
                        q.add(new Node(nx,ny,cur.cnt+1,cur.key));
                        visited[nx][ny][cur.key]=true;
                    }
                }
                else{ // 빈칸인 경우
                    if(!visited[nx][ny][cur.key]){
                        q.add(new Node(nx,ny,cur.cnt+1,cur.key));
                        visited[nx][ny][cur.key]=true;
                    }
                }
            }
        }

        System.out.println(-1);

    }

    static class Node{
        int x,y;
        int cnt;
        int key;

        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", key=" + key +
                    '}';
        }
    }


}
