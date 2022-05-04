package BaekJoon;

import java.util.Scanner;

public class B14499_주사위굴리기 {

    static int n,m;
    static int [][] map;
    static int [] dx={-1,0,1,0}; // 상 좌 하 우 순서
    static int [] dy={0,-1,0,1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        int x=sc.nextInt();
        int y=sc.nextInt();
        int k=sc.nextInt();

        map=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }

        // 초기 주사위 면 상태 - top, up, down, left, right, bottom 순서
        Dice curDice=new Dice(0,1,2,3,4,5);

        int [] dice=new int [6]; // 주사위 각 면의 값을 저장할 배열

        for(int i=0;i<k;++i){
            int dir=sc.nextInt();

            int t=curDice.top;
            int u=curDice.up;
            int d=curDice.down;
            int l=curDice.left;
            int r=curDice.right;
            int b=curDice.bottom;

            Dice nextDice;

            // 방향을 상하좌우 0 1 2 3 순서로 만들고 nextDice에 굴린 후의 주사위 면의 상태 저장
            if(dir==1){ // 오른쪽
                dir=3;
                nextDice=new Dice(r,u,d,t,b,l);

            }
            else if(dir==2){ // 왼
                dir=1;
                nextDice=new Dice(l,u,d,b,t,r);
            }
            else if(dir==3){ // 위
                dir=0;
                nextDice=new Dice(u,b,t,l,r,d);
            }
            else{ // 아래
                dir=2;
                nextDice=new Dice(d,t,b,l,r,u);
            }

            // 굴러갈 위치
            int nx=x+dx[dir];
            int ny=y+dy[dir];

            // 범위를 벗어나는 경우 -> 해당 명령 무시
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

            // 굴릴 수 있는 경우, 현재 주사위를 굴린 후의 주사위 상태로 변경
            curDice=nextDice;
            x=nx; // 주사위 위치 변경
            y=ny;

            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
            if(map[nx][ny]==0){
                map[nx][ny]=dice[nextDice.bottom];
                System.out.println(dice[nextDice.top]);
            }
            else{ // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위 바닥으로 복사
                dice[nextDice.bottom]=map[nx][ny];
                map[nx][ny]=0; // 칸에 쓰여있는 수는 0이 됨
                System.out.println(dice[nextDice.top]);

            }
        }

    }

    static class Dice{
        int top,up,down, left,right, bottom;

        public Dice(int top, int up, int down, int left, int right, int bottom) {
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}
