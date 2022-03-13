package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1916_최소비용구하기 {

    static ArrayList<Node> [] arr;
    static int N,M;
    static int [] dist;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        arr=new ArrayList[N+1];
        dist=new int[N+1];

        for(int i=1;i<=N;++i){
            arr[i]=new ArrayList<>();
            dist[i]=987654321;
        }

        while (M-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr[a].add(new Node(b,c));
        }

        int start=sc.nextInt();
        int end=sc.nextInt();

        bellmanford(start);

        System.out.println(dist[end]);
    }

    public static void bellmanford(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean [] visited=new boolean[N+1];
        pq.add(new Node(start,0));
        dist[start]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.end]) continue;
            visited[cur.end]=true;

            for (Node node : arr[cur.end]) {
                if(!visited[node.end] && dist[node.end]>dist[cur.end]+node.weight){
                    dist[node.end]=dist[cur.end]+node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
}
