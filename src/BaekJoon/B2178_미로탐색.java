package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178_미로탐색 {
    static int n,m;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new int [n][m];

        for(int i=0;i<n;++i){
            String s=sc.next();
            for(int j=0;j<m;++j){
                map[i][j]=s.charAt(j)-'0';
            }
        }


        int answer=bfs(0,0);

        System.out.println(answer);
    }

    public static int bfs(int i, int j){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(i,j,1));
        visited=new boolean[n][m];
        visited[0][0]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();

            if(cur.i==n-1 && cur.j==m-1){
                return cur.cnt;
            }

            for(int k=0;k<4;++k){
                int x=dx[k]+cur.i;
                int y=dy[k]+cur.j;

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && map[x][y]==1){
                    q.add(new Node(x,y,cur.cnt+1));
                    visited[x][y]=true;
                }
            }
        }

        return -1;

    }

    static class Node{
        int i,j,cnt;

        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
