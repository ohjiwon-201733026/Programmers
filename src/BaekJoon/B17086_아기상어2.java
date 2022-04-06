package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17086_아기상어2 {
    static int n,m;
    static int [][] map;
    static int [] dx={0,1,0,-1,1,-1,1,-1};
    static int [] dy={1,0,-1,0,1,-1,-1,1};
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
        int max=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==0){
                    int n=bfs(i,j);
                    max=Math.max(max,n);
                }
            }
        }

        System.out.println(max);
    }


    public static int bfs(int i, int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int []{i,j,0});
        boolean [][] visited=new boolean[n][m];
        visited[i][j]=true;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            if(map[cur[0]][cur[1]]==1){
                return cur[2];
            }

            for(int k=0;k<8;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y]){
                    q.add(new int []{x,y,cur[2]+1});
                    visited[x][y]=true;
                }
            }

        }

        return -1;
    }
}
