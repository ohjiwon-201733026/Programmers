package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2636_치즈 {
    public static int N,M;
    public static int [][] map;
    public static boolean[][] visited;
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        map=new int [N][M];

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                map[i][j]=sc.nextInt();
            }
        }
        int answer=0;
        int cnt=0;
        int beforeCnt=getCount();
        while(true){
            bfs(0,0); // 가장자리 치즈 녹임
            cnt=getCount(); // 남은 치즈 칸 수 세기
            answer++;
            if(cnt==0) break;
            beforeCnt=cnt;
        }
        System.out.println(answer);
        System.out.println(beforeCnt);

    }
    public static boolean isValid(int x, int y){
        return 0<=x && x< N && 0<=y && y<M;
    }

    public static void bfs(int i, int j){
        visited=new boolean[N][M];
        Queue<int []> q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;

        while(!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x= cur[0]+dx[k];
                int y= cur[1]+dy[k];

                if(isValid(x,y) && !visited[x][y]){
                    if(map[x][y]==0){
                        q.add(new int []{x,y});
                        visited[x][y]=true;
                    }
                    if(map[x][y]==1){
                        map[x][y]=2;
                    }
                }
            }

        }

        meltCheeze();

    }

    public static void meltCheeze(){
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j]==2) map[i][j]=0;
            }
        }
    }

    public static int getCount(){
        int cnt=0;
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}
