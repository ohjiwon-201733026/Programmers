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

    public static int [][] map;
    public static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static int INF;
    public static int N;

    public static class Node implements Comparable<Node>{
        int idx;
        int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d-o.d;
        }
    }

    public static int [] dijkstra(int s){
        int [] dist=new int [N+1];
        boolean [] visited=new boolean[N+1];
        pq.add(new Node(s,0));
        Arrays.fill(dist,INF);
        dist[s]=0;
        visited[s]=true;

        while(!pq.isEmpty()){
            Node p=pq.poll();

            for(int i=1;i<=N;++i){
                if(map[p.idx][i]!=INF && !visited[i]){
                        if(dist[i]>(dist[p.idx]+map[p.idx][i])) {
                            dist[i] = (dist[p.idx] + map[p.idx][i]);
                            pq.add(new Node(i,dist[i]));
                        }
                }
            }

            visited[p.idx]=true;

        }
        return dist;
    }
    public static int solution(int n, int s, int a, int b, int [][] fares){
        INF=Integer.MAX_VALUE;
        N=n;
        map=new int [N+1][N+1];

        for(int i=0;i<=N;++i){
            for(int j=0;j<=N;++j){
                map[i][j]=INF;
            }
        }
        for(int[] fare:fares){
            int p1=fare[0];
            int p2= fare[1];
            int d=fare[2];

            map[p1][p2]=d;
            map[p2][p1]=d;
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

        return Math.min(shared, noShared);

    }
}
