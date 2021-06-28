package BaekJoon.Graph;

import java.util.Scanner;

public class B11724_연결요소의개수 {

    public static int [][] graph;
    public static boolean [] visit;
    public static int N,M;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        int answer=0;

       graph=new int[N+1][N+1];
       visit=new boolean [N+1];

       for(int i=0;i<M;++i){
           int x=sc.nextInt();
           int y=sc.nextInt();
           graph[x][y]=graph[y][x]=1;
       }

       for(int i=1;i<=N;++i){
               if(!visit[i]) {
                   dfs(i);
                   answer++;

                }
       }

       System.out.println(answer);


    }

    private static void dfs(int i) {
        if(visit[i]) return;
        else {
            visit[i]=true;
            for(int j=1;j<=N;++j){
                if(graph[i][j]==1) dfs(j);
            }
        }

    }
}
