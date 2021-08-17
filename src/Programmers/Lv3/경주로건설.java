package Programmers.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    public static void main(String [] args){
//        int [][] board={
//                {0, 0, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0, 1},
//                {0, 0, 1, 0, 0, 0, 1, 0},
//                {0, 1, 0, 0, 0, 1, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0}
//        };
//                {0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 0},
//                {0, 0, 1, 0, 0, 0},
//                {1, 0, 0, 1, 0, 1},
//                {0, 1, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0},
//        };
        int [][] board={{0,0,1,0},
                        {0,0,0,0},
                        {0,1,0,1},
                        {1,0,0,0}};
        System.out.println(solution(board));
    }
    private static int n;
    private static int [][]map;
    private static boolean [][] visit;
    private static int [] dx={-1,0,1,0};
    private static int [] dy={0,-1,0,1};
    private static int cost=Integer.MAX_VALUE;
    public static int solution(int [][] board){
        int answer=0;
        n= board.length;
        map=board;
        visit=new boolean[n][n];

        bfs(0,0,-1,0);
        answer=cost;
        return answer;
    }
    public static class Road {
        int x, y, dir, cost;

        Road(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public static void bfs(int x,int y,int dir, int price){
        Queue<Road> q=new LinkedList<>();
        q.add(new Road(x,y,dir,price));
        visit[x][y]=true;

        while(!q.isEmpty()){
            Road road=q.poll();

            int qx=road.x;
            int qy= road.y;
            int qDir= road.dir;
            int qCost= road.cost;

            if(qx==n-1 && qy==n-1) cost=Math.min(cost,qCost);

            for(int i=0;i<dx.length;++i){
                int nx=qx+dx[i];
                int ny=qy+dy[i];
                int nDir=i;
                int nCost=qCost;

                if(nx<0 || ny<0 || nx>=n || ny >=n || map[nx][ny]==1) continue;

                if(qDir==-1) nCost+=100;
                else if(qDir==nDir) nCost+=100;
                else nCost+=600;

                if(!visit[nx][ny] || map[nx][ny]>=nCost){
                    visit[nx][ny]=true;
                    map[nx][ny]=nCost;
                    q.add(new Road(nx,ny,nDir,nCost));
                }
            }

        }
    }
}
