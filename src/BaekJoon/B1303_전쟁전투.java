package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1303_전쟁전투 {
    static int n,m;
    static char [][] map;
    static boolean [][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        map=new char[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;++i){
            String s=sc.next();
            for(int j=0;j<m;++j){
                map[i][j]=s.charAt(j);
            }
        }
        int white=0,blue=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(!visited[i][j]){
                    if(map[i][j]=='W'){
                        int n=bfs(i,j,map[i][j]);
                        white+=n*n;
                    }
                    if(map[i][j]=='B'){
                        int n=bfs(i,j,map[i][j]);
                        blue+=n*n;
                    }
                }
            }
        }

        System.out.println(white+" "+blue);

    }
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    public static int bfs(int i, int j, char c){
        Queue<int [] >q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;
        int num=1;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=dx[k]+cur[0];
                int y=dy[k]+cur[1];

                if(0<=x && x<n && 0<=y &&y<m){
                    if(!visited[x][y] && map[x][y]==c){
                        q.add(new int []{x,y});
                        num++;
                        visited[x][y]=true;
                    }
                }
            }
        }

        return num;
    }
}
