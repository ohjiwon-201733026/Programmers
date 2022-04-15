package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16197_두동전 {
    static int n,m;
    static char [][] map;
    static boolean [][][][] visited;
    static Coin [] coin;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        map=new char [n][m];
        visited=new boolean[n][m][n][m];
        coin=new Coin[2];
        int coinIdx=0;
        for(int i=0;i<n;++i){
            String str=sc.next();
            for(int j=0;j<m;++j){
                char c=str.charAt(j);
                if(c=='o') coin[coinIdx++]=new Coin(i,j);
                map[i][j]=c;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<TwoCoins> q=new LinkedList<>();
        q.offer(new TwoCoins(coin[0].x,coin[0].y,coin[1].x, coin[1].y,0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y]=true;

        while (!q.isEmpty()){
            TwoCoins cur=q.poll();

            if(cur.cnt>=10) break;

            for(int k=0;k<4;++k){
                int nx1=cur.x1+dx[k];
                int ny1=cur.y1+dy[k];
                int nx2=cur.x2+dx[k];
                int ny2=cur.y2+dy[k];

                if(!canMoveCoin(nx1,ny1)){
                    nx1=cur.x1; ny1=cur.y1;
                }
                if(!canMoveCoin(nx2,ny2)){
                    nx2=cur.x2; ny2=cur.y2;
                }

                int flag=0;
                if(nx1>=0 && ny1>=0 && nx1<n && ny1<m) flag++;
                if(nx2>=0 && ny2>=0 && nx2<n && ny2<m) flag++;

                if(flag==1) return cur.cnt+1;
                else if(flag==2 && !visited[nx1][ny1][nx2][ny2]){
                    visited[nx1][ny1][nx2][ny2]=true;
                    q.offer(new TwoCoins(nx1,ny1,nx2,ny2, cur.cnt+1));
                }
            }
        }
        return -1;
    }

    public static boolean canMoveCoin(int nx, int ny){
        if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]=='#') return false;
        return true;
    }

    public static class TwoCoins{
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

    public static class Coin{
        int x,y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
