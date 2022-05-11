package BaekJoon.삼성SW역량;

import java.util.Scanner;

public class B14503_로봇청소기 {

    static int n,m;
    static int [] dx={-1,0,1,0};
    static int [] dy={0,1,0,-1};
    static int [][] map;
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int d=sc.nextInt();

        map=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }

        clean(x,y,d);

        System.out.println(cnt);

    }

    public static void clean(int x, int y, int dir){
        // 1. 현재 위치 청소
        if(map[x][y]==0){
            map[x][y]=2;
            cnt++;
        }

        // 2. 왼쪽 방향부터 차례대로 탐색을 진행한다
        boolean flag=false;
        int origin=dir;
        for(int i=0;i<4;++i){
            int nextD=(dir+3)%4;
            int nextX=x+dx[nextD];
            int nextY=y+dy[nextD];

            if(nextX>=0 && nextY>=0 && nextX<n && nextY<m){
                if(map[nextX][nextY]==0){
                    clean(nextX,nextY,nextD);
                    flag=true;
                    break;
                }
            }

            dir=nextD;
        }
        // 4방향 모두 청소가 되었거나 벽인 경우(후진)
        if(!flag){
            int nextD=(origin+2)%4;
            int nextX=x+dx[nextD];
            int nextY=y+dy[nextD];

            if(nextX>=0 && nextY>=0 && nextX<n && nextY<m){
                if(map[nextX][nextY] != 1){ // 벽인 경우 작동 끝
                    clean(nextX,nextY,origin); // 바라보는 방향 유지한채 후진
                }
            }
        }
    }


}
