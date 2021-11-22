package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3197_백조의호수 {
    public static String[][] map;
    public static boolean[][] visited;
    public static int R, C;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new String[R][C];
        visited = new boolean[R][C];
        int x=0,y=0;
        for (int i = 0; i < R; ++i) {
            String[] a = sc.next().split("");
            for (int j = 0; j < C; ++j) {
                map[i][j] = a[j];
                if(map[i][j].equals("L")) {
                    x=i;y=j;
                }
            }
        }

        String[][] tmp;

        int answer=0;
        while(true){
            tmp= melt();
            copy(tmp);
            visited=new boolean[R][C];
            boolean flag=bfs(x,y);
            answer++;
            if(flag) break;

        }
        System.out.println(answer);

    }
    private static int [] dx={0,1,0,-1};
    private static int [] dy={1,0,-1,0};
    private static boolean bfs(int x, int y) {
        Queue<int []> q=new LinkedList<>();
        visited[x][y]=true;
        q.add(new int []{x,y});
        int a=1;
        while(!q.isEmpty()){
            int [] cur=q.poll();
            int curX=cur[0],curY=cur[1];
            if(map[curX][curY].equals("L") && (curX!=x || curY!=y)){

                 return true;
            }

            for(int k=0;k<4;++k){
                int i=curX+dx[k];
                int j=curY+dy[k];

                if(check(i,j)){
                    if(!visited[i][j] && !map[i][j].equals("X")){
                        q.add(new int []{i,j});
                        visited[i][j]=true;
                    }
                }
            }

        }
        return false;
    }

    private static void copy(String[][] a) {
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                map[i][j] = a[i][j];
            }
        }
    }

    private static String[][] melt() {
        String[][] tmp = new String[R][C];
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {

                if(map[i][j].equals("X")){
                    if(check(i,j-1) && map[i][j-1].equals(".")) tmp[i][j]=".";
                    if(check(i,j+1) && map[i][j+1].equals(".")) tmp[i][j]=".";
                    if(check(i-1,j) && map[i-1][j].equals(".")) tmp[i][j]=".";
                    if(check(i+1,j) && map[i+1][j].equals(".")) tmp[i][j]=".";
                }
            }
        }
        return tmp;
    }

    private static boolean check(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }


}
