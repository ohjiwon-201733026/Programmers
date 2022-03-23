package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502_연구소 {
    static int n,m;
    static int [][] map;
    static final int WALL=1;
    static final int EMPTY=0;
    static final int VIRUS=2;
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        map=new int [n][m];

        max=0;

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

        System.out.println(max);


    }
    static int max;
    static boolean [][] visited;
    public static void dfs(int cnt, int [][] map){

        
        if(cnt==3){
            int num=0;
            int [][] tmp=copy(map);
            tmp=virus(tmp);
            visited=new boolean[n][m];
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(tmp[i][j]==EMPTY&& !visited[i][j]){
                        num+=bfs(i,j,tmp);
                    }
                }
            }

            max=Math.max(max,num);
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

    public static int [][] copy(int [][] map){
        int [][] tmp=new int [map.length][map[0].length];

        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[0].length;++j){
                tmp[i][j]=map[i][j];
            }
        }
        return tmp;
    }

    public static int [][] virus(int [][] map){
        int [][] tmp=copy(map);
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==VIRUS){

                    tmp=virus_bfs(i,j,tmp);
                }
            }
        }
        return tmp;
    }

    public static int [][] virus_bfs(int i,int j, int [][] map){
         Queue<int[]> q=new LinkedList<>();
         boolean [][] visited=new boolean[n][m];

         q.add(new int []{i,j});
         visited[i][j]=true;

         while (!q.isEmpty()){
             int[] cur=q.poll();

             for(int k=0;k<4;++k){
                 int x=dx[k]+cur[0];
                 int y=dy[k]+cur[1];

                 if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && map[x][y]==EMPTY){
                     map[x][y]=VIRUS;
                       q.add(new int []{x,y});
                       visited[x][y]=true;
                 }
             }
         }
         return map;
    }

    public static int bfs(int i, int j, int [][] map){
        int [][] tmp=copy(map);
        Queue<int[]> q=new LinkedList<>();

        q.add(new int []{i,j});
        visited[i][j]=true;
        int a=1;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=dx[k]+cur[0];
                int y=dy[k]+cur[1];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && tmp[x][y]==EMPTY){
                    q.add(new int []{x,y});
                    a++;
                    visited[x][y]=true;

                }
            }
        }
        return a;
    }
}
