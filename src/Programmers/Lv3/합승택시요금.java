package Programmers.Lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {
    public static void main(String [] args){
        int n=6;
        int s=4;
        int a=6;
        int b=2;
        int [][] fares={{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n,s,a,b,fares));
    }
    static class Node implements Comparable<Node>{
        int idx,dist;
        public Node(int idx, int dist){
            this.idx=idx;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }
    }
    static int N,INF;
    static int [][] graph;

    public static int solution(int n,int s, int a, int b,int [][] fares){
        N=n;
        INF=987654321;
        graph=new int [N+1][N+1];

        for(int i=0;i<=N;++i){
            Arrays.fill(graph[i],INF);
        }

        for(int [] far : fares){
            int n1=far[0];
            int n2=far[1];
            int dist=far[2];

            graph[n1][n2]=dist;
            graph[n2][n1]=dist;
        }

        int [] sDist=dijkstra(s);
        int [] aDist=dijkstra(a);
        int [] bDist=dijkstra(b);

        int noShared=sDist[a]+sDist[b];

        int shared=Integer.MAX_VALUE;
        for(int i=1;i<=N;++i){
            if(sDist[i]==INF || aDist[i]==INF || bDist[i]==INF) continue;

            shared=Math.min(shared,sDist[i]+aDist[i]+bDist[i]);
        }

        return Math.min(noShared,shared);
    }

    private static int[] dijkstra(int from) {
        PriorityQueue<Node> pq=new PriorityQueue<>();

        int [] dist=new int [N+1];
        boolean [] visited=new boolean[N+1];

        Arrays.fill(dist,INF);

        dist[from]=0;
        pq.add(new Node(from,0));

        while(!pq.isEmpty()){
            int here=pq.peek().idx;
            int cost=pq.peek().dist;
            pq.poll();

//            if(cost<dist[here]) continue;

            for(int i=1;i<=N;++i){
                if(graph[here][i]!=INF && !visited[i]){
                    if(dist[i]>(dist[here]+graph[here][i])){
                        dist[i]=(dist[here]+graph[here][i]);
                        pq.add(new Node(i,dist[i]));
                    }
                }
            }

            visited[here]=true;
        }
        return dist;
    }
}
