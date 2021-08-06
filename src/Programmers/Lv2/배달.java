package Programmers.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {

    public static void main(String[] args) {
        int N=5;
        int [][] road={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int k=3;
        System.out.println(solution(N,road,k));
    }

    public static class Node implements Comparable<Node> {
        int num;
        int d;

        public Node(int num, int d){
            this.num=num;
            this.d=d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d-o.d;
        }
    }

    public static int solution(int N, int [][] road, int k){
        int [][] map=new int [N+1][N+1];
        int [] dist=new int[N+1];
        boolean [] visit=new boolean[N+1];
        final int INF=Integer.MAX_VALUE;
        List<Node>[] list=new ArrayList[N+1];

        for(int i=1;i<=N;++i) list[i]=new ArrayList<>();
        for(int i=0;i<road.length;++i){
            int [] r=road[i];
            list[r[0]].add(new Node(r[1],r[2]));
            list[r[1]].add(new Node(r[0],r[2]));
        }
        for(int i=1;i<=N;++i) dist[i]=INF;

        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        pq.add(new Node(1,0));
        dist[1]=0;


        while(!pq.isEmpty()){
            Node p=pq.poll();

            if(visit[p.num]) continue;
            visit[p.num]=true;

            for(Node node:list[p.num]){
                if(!visit[node.num] && dist[node.num]>dist[p.num]+p.d){
                    dist[node.num]=dist[p.num]+p.d;
                    pq.add(new Node(node.num,dist[node.num]));
                }
            }

//            visit[p.num]=true;
        }
        int answer=0;
        for(int i=1;i<=N;++i){
            if(dist[i]<=k) answer++;
        }

        return answer;
    }
}
