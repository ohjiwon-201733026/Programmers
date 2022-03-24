package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502_연구소 {
    static int n,m;
    static int [][] map;
    static final int VIRUS=2;
    static final int EMPTY=0;
    static final int WALL=1;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       n=sc.nextInt();
       m=sc.nextInt();
       map=new int [n][m];

       for(int i=0;i<n;++i){
           for(int j=0;j<m;++j){
               map[i][j]=sc.nextInt();
           }
       }

       for(int i=0;i<n;++i){
           for(int j=0;j<m;++j){
               if(map[i][j]==EMPTY){
                   map[i][j]=WALL;
                   int [][] tmp=copy(map);
                   dfs(1,tmp);
                   map[i][j]=EMPTY;
               }
           }
       }

        System.out.println(answer);
    }
    static int answer=0;
    static boolean [][] visited;
    static void dfs(int cnt, int [][] map){
        if(cnt==3){
            // wall 3개 다 지어지면
            int [][] tmp=copy(map);
            tmp=virus(tmp);
            int sum=0;
            visited=new boolean[n][m];
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(tmp[i][j]==EMPTY && !visited[i][j])
                    sum+=bfs(i,j,tmp);
                }
            }

            answer=Math.max(answer,sum);
            return;
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==EMPTY){
                    map[i][j]=WALL;
                    int [][] tmp=copy(map);
                    dfs(cnt+1,tmp);
                    map[i][j]=EMPTY;
                }
            }
        }
    }
    static int bfs(int i, int j, int [][] map){
        Queue<int []> q=new LinkedList<>();
        visited[i][j]=true;
        q.add(new int []{i,j});
        int sum=1;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=dx[k]+cur[0];
                int y=dy[k]+cur[1];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && map[x][y]==EMPTY){
                    sum++;
                    visited[x][y]=true;
                    q.add(new int []{x,y});
                }
            }
        }

        return sum;
    }
    static int [][] virus(int [][] map){
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==VIRUS) q.add(new int []{i,j});
            }
        }

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=dx[k]+cur[0];
                int y=dy[k]+cur[1];

                if(0<=x && x<n && 0<=y && y<m && map[x][y]==EMPTY){
                    q.add(new int []{x,y});
                    map[x][y]=VIRUS;
                }
            }
        }

        return map;

    }
    static int[][] copy(int [][] map){
        int [][] tmp=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                tmp[i][j]=map[i][j];
            }
        }
        return tmp;
    }
}
