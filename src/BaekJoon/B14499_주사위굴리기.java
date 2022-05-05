package BaekJoon;

import java.util.Scanner;

public class B14499_주사위굴리기 {

    static int n,m,x,y,k;
    static int [] dx={0,0,-1,1};
    static int [] dy={1,-1,0,0};
    static int [][] map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        x=sc.nextInt();
        y=sc.nextInt();
        k=sc.nextInt();

        map=new int [n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }

        Dice curDice=new Dice(0,1,2,3,4,5);
        int [] diceVal=new int [6];

        while (k-->0){
            int dir=sc.nextInt();

            int t=curDice.top;
            int l=curDice.left;
            int r=curDice.right;
            int u=curDice.up;
            int d=curDice.down;
            int b=curDice.bottom;

            Dice nextDice;

            if(dir==1){ // 오른쪽
                dir=0;
                nextDice=new Dice(r,t,b,u,d,l);
            }
            else if(dir==2){
                dir=1;
                nextDice=new Dice(l,b,t,u,d,r);
            }
            else if(dir==3){
                dir=2;
                nextDice=new Dice(u,l,r,b,t,d);
            }
            else{
                dir=3;
                nextDice=new Dice(d,l,r,t,b,u);
            }

            int nx=x+dx[dir];
            int ny=y+dy[dir];

            if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;

            if(map[nx][ny]==0){
                map[nx][ny]=diceVal[nextDice.top];
                System.out.println(diceVal[nextDice.bottom]);
            }
            else{
                diceVal[nextDice.top]=map[nx][ny];
                map[nx][ny]=0;
                System.out.println(diceVal[nextDice.bottom]);
            }

            curDice=nextDice;

            x=nx;
            y=ny;
        }
    }

    static class Dice{
        int top,left,right,up,down,bottom;

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
