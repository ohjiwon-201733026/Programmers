package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16197_두동전 {

    static int n,m;
    static char [][] map;
    static  boolean [][][][] visited;
    static Coin[] coins;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new char [n][m];
        visited=new boolean[n][m][n][m];
        coins=new Coin[2];

        int idx=0;
        for(int i=0;i<n;++i){
            String str=sc.next();
            for(int j=0;j<m;++j){
                map[i][j]=str.charAt(j);
                if(map[i][j]=='o'){
                    coins[idx]=new Coin(i,j);
                    idx++;
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        Queue<TwoCoins> q=new LinkedList<>();
        q.add(new TwoCoins(coins[0].x,coins[0].y,coins[1].x,coins[1].y,0));
        visited[coins[0].x][coins[0].y][coins[1].x][coins[1].y]=true;

        while (!q.isEmpty()){
            TwoCoins cur=q.poll();

            if(cur.cnt>=10) return -1;

            for(int k=0;k<4;++k){
                int nx1=cur.x1+dx[k];
                int ny1=cur.y1+dy[k];
                int nx2=cur.x2+dx[k];
                int ny2=cur.y2+dy[k];

                if(!canMove(nx1,ny1)){
                    nx1=cur.x1;
                    ny1=cur.y1;
                }

                if(!canMove(nx2,ny2)){
                    nx2=cur.x2;
                    ny2=cur.y2;
                }

                int flag=0; // 보드 위에 있는 동전 수
                if(in(nx1,ny1)) flag++;
                if(in(nx2,ny2)) flag++;

                if(flag==1) return cur.cnt+1;

                if(flag==2 && !visited[nx1][ny1][nx2][ny2]){
                    q.add(new TwoCoins(nx1,ny1,nx2,ny2,cur.cnt+1));
                    visited[nx1][ny1][nx2][ny2]=true;
                }
            }
        }

        return -1;
    }

    static boolean in(int x, int y){
        return 0<=x && x<n && 0<=y && y<m;
    }

    static boolean canMove(int x,int y){
        if(0<=x && x<n && 0<=y && y<m && map[x][y]=='#') return false;
        return true;
    }

    static class TwoCoins{
        int x1,y1,x2,y2;
        int cnt;

        public TwoCoins(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    static class Coin{
        int x,y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
