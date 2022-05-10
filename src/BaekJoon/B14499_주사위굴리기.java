package BaekJoon;

import java.util.Scanner;

public class B14499_주사위굴리기 {

    static int n,m,x,y,k,d;
    static int [][] board;
    static int [] dx={0,0,1,-1};
    static int [] dy={1,-1,0,0}; // 동, 서, 남, 북 순
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        x=sc.nextInt();
        y=sc.nextInt();

        k=sc.nextInt();
        d=0;

        board=new int [n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                board[i][j]=sc.nextInt();
            }
        }

        int px=x;
        int py=y;

        int [] dice=new int [6];

        Dice curDice=new Dice(0,1,2,3,4,5);


        for(int i=0;i<k;++i){
            int dir=sc.nextInt();

            int t=curDice.top;
            int l=curDice.left;
            int r=curDice.right;
            int u=curDice.up;
            int d=curDice.down;
            int b=curDice.bottom;

            Dice nextDice = null;
            if(dir==1){ // 동
                dir=0;
                nextDice=new Dice(r,t,b,u,d,l);
            }

            if(dir==2){ // 서
                dir=1;
                nextDice=new Dice(l,b,t,u,d,r);
            }

            if(dir==3){ // 북
                dir=3;
                nextDice=new Dice(u,l,r,b,t,d);
            }

            if(dir==4){
                dir=2;
                nextDice=new Dice(d,l,r,t,b,u);
            }

            int nx=px+dx[dir];
            int ny=py+dy[dir];
            if(nx<0 || nx> n-1 || ny<0 || ny>m-1) continue;

            if(board[nx][ny]==0){
                board[nx][ny]=dice[nextDice.top];
            }
            else{
                dice[nextDice.top]=board[nx][ny];
                board[nx][ny]=0;
            }

            System.out.println(dice[nextDice.bottom]);
            px=nx;
            py=ny;
            curDice=nextDice;


        }
    }

    static class Dice{
        int top,left, right, up, down, bottom;

        public Dice(int top, int left, int right, int up, int down, int bottom) {
            this.top = top;
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
            this.bottom = bottom;
        }
    }
}
