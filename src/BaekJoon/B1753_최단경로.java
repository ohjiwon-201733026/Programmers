package BaekJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1753_최단경로 {
    static ArrayList<Node>[] arr;
    static int [] d;
    static final int INF=Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(Node o) {
            return w-o.w;
        }
    }
    static int V,E;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        E=sc.nextInt();
        int start=sc.nextInt();

        arr=new ArrayList[V+1];
        d=new int [V+1];

        for(int i=1;i<=V;++i){
            d[i]=INF;
        }

        for(int i=1;i<=V;++i) arr[i]=new ArrayList<>();
        while(E-->0){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();

            arr[u].add(new Node(v,w));
        }
        dijkstra(start);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=V;++i){
            if(d[i]==INF) sb.append("INF\n");
            else sb.append(d[i]+"\n");
        }

        System.out.println(sb.toString());


    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean [] check=new boolean[V+1];
        pq.add(new Node(start,0));
        d[start]=0;

        while(!pq.isEmpty()){
            Node n=pq.poll();

            if(check[n.v]==true) continue;
            check[n.v]=true;

            for(Node node : arr[n.v]){
                if(d[node.v]>d[n.v]+node.w){
                    d[node.v]=d[n.v]+node.w;
                    pq.add(new Node(node.v,d[node.v]));
                }
            }
        }
    }
}
