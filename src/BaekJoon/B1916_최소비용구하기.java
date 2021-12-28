package BaekJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1916_최소비용구하기 {

    static int N,M;
    static ArrayList<Node>[] arr;
    static int [] dist;
    static final int INF=Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        arr=new ArrayList[N+1];
        dist=new int [N+1];

        for(int i=1;i<=N;++i) arr[i]=new ArrayList<>();
        for(int i=1;i<=N;++i) dist[i]=INF;

        while(M-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int w=sc.nextInt();

            arr[a].add(new Node(b,w));
        }

        int start=sc.nextInt();
        int end=sc.nextInt();

        dijkstra(start);

        System.out.println(dist[end]);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start]=0;
        boolean [] visited=new boolean[N+1];

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int curE=cur.end;

            if(visited[curE]) continue;
            visited[curE]=true;

            for (Node node : arr[curE]) {
                if(dist[node.end]>dist[curE]+ node.weight){
                    dist[node.end]=dist[curE]+ node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
    }
}
