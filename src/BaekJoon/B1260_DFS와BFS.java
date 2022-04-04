package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260_DFS와BFS {
    static int [][] map;
    static boolean [] visited;
    static int n,m,v;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        v=sc.nextInt();
        map=new int [n+1][n+1];
        visited=new boolean[n+1];

        for(int i=0;i<m;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            map[a][b]=1;
            map[b][a]=1;
        }

        dfs(v);
        visited=new boolean[n+1];
        System.out.println();
        bfs(v);
    }

    public static void dfs(int v){
        System.out.print(v+" ");

        visited[v]=true;

        for(int i=1;i<n+1;++i){
            if(!visited[i] && map[v][i]==1){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        visited[v]=true;

        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            int num=q.poll();

            for(int i=1;i<=n;++i){
                if(!visited[i] && map[num][i]==1){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}
