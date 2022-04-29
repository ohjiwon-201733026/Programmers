package BaekJoon.삼성SW역량;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13260_구슬탈출2 {
    static int N,M;
    static char [][] map;
    static boolean [][][][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    // 0: 오른, 1: 아래, 2: 왼, 3:위
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        map=new char[N][M];

        int rX=0,rY=0,bX=0,bY=0;
        for(int i=0;i<N;++i){
            String s=sc.next();
            for(int j=0;j<M;++j){
                map[i][j]=s.charAt(j);
                if(map[i][j]=='R'){
                    rX=i; rY=j;
                    map[i][j]='.';
                }
                if(map[i][j]=='B'){
                    bX=i;bY=j;
                    map[i][j]='.';
                }
            }
        }

//        move(0,new Node(rX,rY,bX,bY,0));

        visited=new boolean[N][M][N][M];
        System.out.println(bfs(rX,rY,bX,bY));
    }

    static int bfs(int rX, int rY, int bX, int bY){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(rX,rY,bX,bY,0));
        visited[rX][rY][bX][bY]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();

            if(cur.cnt>10) return -1;
            if(map[cur.rX][cur.rY]=='O') return cur.cnt;

            for(int k=0;k<4;++k){
                int [] next=move(k,cur);
                int nextRx=next[0],nextRy=next[1],nextBx=next[2],nextBy=next[3];

                if(visited[nextRx][nextRy][nextBx][nextBy]) continue;
                if(map[nextBx][nextBy]=='O') continue;

                q.add(new Node(nextRx,nextRy,nextBx,nextBy,cur.cnt+1));
                visited[nextRx][nextRy][nextBx][nextBy]=true;

            }
        }

        return -1;
    }
    
    static int [] move(int dir, Node cur){
        int nextRx=cur.rX,nextRy=cur.rY,nextBx=cur.bX,nextBy=cur.bY;
        // 0: 오른, 1: 아래, 2: 왼, 3:위
        if(dir==0){ // 오른
            boolean flag=false;
            while ( nextRy<M && map[nextRx][nextRy]!='#' ){
                if(map[nextRx][nextRy]=='O'){
                    flag=true;
                    break;
                }
                nextRx+=dx[dir];
                nextRy+=dy[dir];
            }
            if(!flag) {
                nextRx -= dx[dir];
                nextRy -= dy[dir];
            }
            flag=false;
            while ( nextBy<M && map[nextBx][nextBy]!='#'){
                if(map[nextBx][nextBy]=='O'){
                    flag=true;
                    break;
                }
                nextBx+=dx[dir];
                nextBy+=dy[dir];
            }
            if(!flag) {
                nextBx -= dx[dir];
                nextBy -= dy[dir];
            }
            if(nextRx==nextBx && nextRy==nextBy && map[nextRx][nextRy]!='O'){
                if(cur.rY<cur.bY) nextRy-=dy[dir];
                else nextBy-=dy[dir];
            }
        }
        
        if(dir==1){ // 아래
            boolean flag=false;
            while (nextRx<N&& map[nextRx][nextRy]!='#'){
                if(map[nextRx][nextRy]=='O'){
                    flag=true;
                    break;
                }
                nextRx+=dx[dir];
                nextRy+=dy[dir];
            }
            if(!flag) {
                nextRx -= dx[dir];
                nextRy -= dy[dir];
            }
            flag=false;
            while (nextBx<N && map[nextBx][nextBy]!='#'){
                if(map[nextBx][nextBy]=='O'){
                    flag=true;
                    break;
                }
                nextBx+=dx[dir];
                nextBy+=dy[dir];
            }
            if(!flag) {
                nextBx -= dx[dir];
                nextBy -= dy[dir];
            }
            if(nextRx==nextBx && nextRy==nextBy&& map[nextRx][nextRy]!='O'){
                if(cur.rX<cur.bX) nextRx-=dx[dir];
                else nextBx-=dx[dir];
            }
        }
        
        if(dir==2){ // 왼
            boolean flag=false;
            while (0<=nextRx&&map[nextRx][nextRy]!='#'){
                if(map[nextRx][nextRy]=='O'){
                    flag=true;
                    break;
                }
                nextRx+=dx[dir];
                nextRy+=dy[dir];
            }
            if(!flag) {
                nextRx -= dx[dir];
                nextRy -= dy[dir];
            }

            flag=false;
            while (0<=nextBx && map[nextBx][nextBy]!='#' ){
                if(map[nextBx][nextBy]=='O'){
                    flag=true;
                    break;
                }
                nextBx+=dx[dir];
                nextBy+=dy[dir];
            }
            if(!flag) {
                nextBx -= dx[dir];
                nextBy -= dy[dir];
            }
            if(nextRx==nextBx && nextRy==nextBy&& map[nextRx][nextRy]!='O'){
                if(cur.rY<cur.bY) nextBy-=dy[dir];
                else nextRy-=dy[dir];
            }
        }

        if(dir==3){ // 위
            boolean flag=false;
            while (nextRx>=0&& map[nextRx][nextRy]!='#'){
                if(map[nextRx][nextRy]=='O'){
                    flag=true;
                    break;
                }
                nextRx+=dx[dir];
                nextRy+=dy[dir];
            }
            if(!flag) {
                nextRx -= dx[dir];
                nextRy -= dy[dir];
            }

            flag=false;
            while (nextBx>=0 && map[nextBx][nextBy]!='#'){
                if(map[nextBx][nextBy]=='O'){
                    flag=true;
                    break;
                }
                nextBx+=dx[dir];
                nextBy+=dy[dir];
            }
            if(!flag) {
                nextBx -= dx[dir];
                nextBy -= dy[dir];
            }
            if(nextRx==nextBx && nextRy==nextBy&& map[nextRx][nextRy]!='O'){
                if(cur.rX<cur.bX) nextBx-=dx[dir];
                else nextRx-=dx[dir];
            }
        }

//        map[cur.rX][cur.rY]='.';
//        map[cur.bX][cur.bY]='.';
//        map[nextRx][nextRy]='R';
//        map[nextBx][nextBy]='B';

//        for(int i=0;i<N;++i){
//            for(int j=0;j<M;++j){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(nextRx+" "+nextRy+" "+nextBx+" "+nextBy);

        return new int []{nextRx,nextRy,nextBx,nextBy};
    }
    

    static class Node{
        int rX,rY,bX,bY;
        int cnt;

        public Node(int rX, int rY, int bX, int bY, int cnt) {
            this.rX = rX;
            this.rY = rY;
            this.bX = bX;
            this.bY = bY;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "rX=" + rX +
                    ", rY=" + rY +
                    ", bX=" + bX +
                    ", bY=" + bY +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
