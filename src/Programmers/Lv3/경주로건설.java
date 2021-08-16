package Programmers.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    public static void main(String [] args){
        int [][] board={
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
//        int [][] board={{0,0,1,0},
//                        {0,0,0,0},
//                        {0,1,0,1},
//                        {1,0,0,0}};
        System.out.println(solution(board));
    }
    public static int N;
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    public static boolean [][] visited;
    public static int [][] map;
    public static int [][] dp;
    public static char [] dir={'l','d','r','u'};
    public static int solution(int [][] board){
        N= board.length;
        map=board;
        dp=new int [N][N];
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        visited=new boolean [board.length][board[0].length];
        int answer=bfs(0,0);
        return answer;
    }

    public static class Point{
        int x,y;
        char dir;
        int cost;
        int rot=0;
        String s="";

        Point(int x, int y, char dir , int cost,int rot,String s){
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.cost=cost;
            this.rot=rot;
            this.s=s;
        }
    }
    public static int bfs(int x,int y){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(x,y,'x',100,0,""));
        dp[x][y]=100;
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Point cur=q.poll();

            dp[cur.x][cur.y]=(cur.cost)+cur.rot*500;


            for(int k=0;k<4;++k){
                int nextX=cur.x+dx[k];
                int nextY=cur.y+dy[k];
                int rot=cur.rot;
                int cost=cur.cost;
                if( 0<=nextX && nextX <N && 0<=nextY && nextY<N  && map[nextX][nextY]==0){

                    if((cur.dir=='l' || cur.dir=='r') && (k==1 || k==3)) rot++;
                    else if((cur.dir=='u' || cur.dir=='d') && (k==0 || k==2)) rot++;
                    cost+=100;
                    if(dp[nextX][nextY]>(cost-100)+rot*500){
                        q.add(new Point(nextX, nextY, dir[k], cost,rot,cur.s+"("+nextX+","+nextY+")"));
                    }

                }

            }
        }



        return dp[N-1][N-1]-100;
    }
}
