package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1012_유기농배추 {
    static int n,m;
    static int [][] arr;
    static boolean[][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        while (t-->0){
            m=sc.nextInt();
            n=sc.nextInt();
            int k=sc.nextInt();

            arr=new int [n][m];
            visited=new boolean[n][m];

            for(int i=0;i<k;++i){
                int y=sc.nextInt();
                int x=sc.nextInt();
                arr[x][y]=1;
            }
            int cnt=0;
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(!visited[i][j] && arr[i][j]==1){
                        cnt++;
                        bfs(i,j);
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());
    }

    public static void bfs(int i, int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && arr[x][y]==1){
                    q.add(new int []{x,y});
                    visited[x][y]=true;
                }

            }
        }
    }
}
