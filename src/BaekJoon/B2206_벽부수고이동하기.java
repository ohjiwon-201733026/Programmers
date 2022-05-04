package BaekJoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기 {

    static int n,m;
    static int [][] map;
    static boolean [][][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        map=new int [n][m];
        visited=new boolean[n][m][2];

        for(int i=0;i<n;++i){
            String s=sc.next();
            for(int j=0;j<m;++j){
                map[i][j]=s.charAt(j)-'0';
            }
        }

        System.out.println(bfs(0,0,1));
    }

    static int bfs(int i, int j, int cnt){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(i,j,cnt,0));
        visited[i][j][0]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();

            if(cur.x==n-1 && cur.y==m-1){
                return cur.cnt;
            }

            for(int k=0;k<4;++k){
                int nx=cur.x+dx[k];
                int ny=cur.y+dy[k];

                if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;

                if(cur.breakWall==1){ // 이미 벽을 깬 경우
                    if(map[nx][ny]==0 && !visited[nx][ny][1]){ // 빈칸으로만 이동 가능
                        q.add(new Node(nx,ny,cur.cnt+1,1));
                        visited[nx][ny][1]=true;
                    }
                }
                else{ // 아직 벽 깨지 않은 경우
                    if(map[nx][ny]==0 && !visited[nx][ny][0]){ // 빈칸 이동
                        q.add(new Node(nx,ny,cur.cnt+1,0));
                        visited[nx][ny][0]=true;
                    }
                    if(map[nx][ny]==1 && !visited[nx][ny][1]){ // 벽 깨기 가능
                        q.add(new Node(nx,ny,cur.cnt+1,1));
                        visited[nx][ny][1]=true;
                    }
                }
            }


        }

        return -1;
    }

    static class Node{
        int x, y, cnt,breakWall;

        public Node(int x, int y, int cnt,int breakWall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall=breakWall;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", breakWall=" + breakWall +
                    '}';
        }
    }

}
