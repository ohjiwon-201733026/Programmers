package BaekJoon.삼성SW역량;

import java.util.Scanner;

public class B14503_로봇청소기 {

    static int n,m;
    static int [][] map;
    static int [] dx={-1,0,1,0};
    static int [] dy={0,1,0,-1};
    static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new int [n][m];
        int x=sc.nextInt();
        int y=sc.nextInt();

        int d=sc.nextInt();

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }
        cnt=0;
        clean(x,y,d);
        System.out.println(cnt);
    }

    public static void clean(int x, int y, int dir){
        if(map[x][y]==0){
            map[x][y]=2;
            cnt++;
        }

        boolean flag=false;
        int origin=dir;
        for(int k=0;k<4;++k){
            int nextD=(dir+3)%4;
            int nextX=x+dx[nextD];
            int nextY=y+dy[nextD];

            if(0<=nextX && nextX<n && 0<=nextY && nextY<m && map[nextX][nextY]==0){
                clean(nextX,nextY,nextD);
                flag=true;
                break;
            }
            dir=nextD;

        }

        if(!flag){
            int nextD=(origin+2)%4;
            int nextX=x+dx[nextD];
            int nextY=y+dy[nextD];

            if(0<=nextX && nextX<n && 0<=nextY && nextY<m && map[nextX][nextY]!=1){
                clean(nextX,nextY,origin);
            }
        }




    }


}
