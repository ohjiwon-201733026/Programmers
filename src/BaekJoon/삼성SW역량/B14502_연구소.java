package BaekJoon.삼성SW역량;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502_연구소 {

    static int n,m;
    static int answer=0;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static boolean [][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        int [][] map=new int [n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==0) {
                    map[i][j] = 1;
                    backTracking(map, 1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    static void backTracking(int [][] map, int depth){
        if(depth==3){
            int [][] tmp=copy(map);
            tmp=virus(tmp);
            visited=new boolean[n][m];
            int sum=0;
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(tmp[i][j]==0 && !visited[i][j]) {
                        sum+=bfs(i,j,tmp);
                    }
                }
            }

            answer=Math.max(answer,sum);
            return;
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==0) {
                    map[i][j] = 1;
                    backTracking(map, depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs(int i,int j, int [][] tmp){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;
        int cnt=1;
        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && tmp[x][y]==0){
                    cnt++;
                    q.add(new int []{x,y});
                    visited[x][y]=true;
                }
            }
        }

        return cnt;
    }

    static int [][] virus(int [][] map){
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==2) q.add(new int []{i,j});
            }
        }

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<n && 0<=y && y<m && map[x][y]==0){
                    q.add(new int []{x,y});
                    map[x][y]=2;
                }
            }
        }

        return map;
    }

    public static int [][] copy(int [][] arr){
        int [][] tmp=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                tmp[i][j]=arr[i][j];
            }
        }

        return tmp;
    }


}
