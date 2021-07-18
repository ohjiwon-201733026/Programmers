package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public static void main(String[] args) {
        int [][] maps={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer=solution(maps);
        System.out.println(answer);

    }
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    public static int [][] map;
    public static boolean [][] visited;
    public static int N,M;
    private static int solution(int[][] maps) {
        N= maps.length;
        M=maps[0].length;
        visited=new boolean[N][M];
        map=maps;

        int n=bfs(0,0);

        return n;

    }

    public static class Point{
        int i;
        int j;
        int distance;

        public Point(int i,int j, int distance){
            this.i=i;
            this.j=j;
            this.distance=distance;
        }
    }

    public static int bfs(int i,int j){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(i,j,1));
        visited[i][j]=true;

        while(!q.isEmpty()){
            Point p=q.poll();

            if(p.i==N-1 && p.j==M-1) return p.distance;

            for(int k=0;k<4;++k){
                int x=p.i+dx[k];
                int y=p.j+dy[k];

                if(0<=x&& x<N && 0<=y && y<M){
                    if(map[x][y]==1 && !visited[x][y] ) {
                        visited[x][y]=true;
                        q.add(new Point(x,y,p.distance+1));
                    }
                }
            }
        }

        return -1;
    }
}
