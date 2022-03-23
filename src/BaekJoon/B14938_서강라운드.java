package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B14938_서강라운드 {

    static int n,m,r;
    static int [] items;
    static ArrayList<Node>[] route;
    static int [][] dist;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        r=sc.nextInt();

        items=new int [n+1];
        route=new ArrayList[n+1];
        dist=new int [n+1][n+1];
        for(int i=1;i<=n;++i) items[i]=sc.nextInt();
        for(int i=0;i<=n;++i) route[i]=new ArrayList<>();
        for(int i=1;i<=n;++i) Arrays.fill(dist[i],Integer.MAX_VALUE);

        while (r-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            route[a].add(new Node(b,c));
            route[b].add(new Node(a,c));
        }


        for(int i=1;i<=n;++i){
            dijkstra(i);
        }

        int answer=0;
        for(int i=1;i<=n;++i){
            int sum=0;
            for(int j=1;j<=n;++j){
                if(dist[i][j]<=m){
                    sum+=items[j];
                }
            }
            answer=Math.max(answer,sum);

        }

        System.out.println(answer);

    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        boolean [] visited=new boolean[n+1];
        dist[start][start]=0;

        while (!pq.isEmpty()){
            Node cur= pq.poll();

            if(visited[cur.to]) continue;
            visited[cur.to]=true;

            for (Node next : route[cur.to]) {
                if(!visited[next.to] && dist[start][next.to]>dist[start][cur.to]+next.cost){
                    dist[start][next.to]=dist[start][cur.to]+next.cost;
                    pq.add(new Node(next.to, dist[start][next.to]));
                }
            }
        }


    }

    public static class Node implements Comparable<Node>{
        int to,cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
}
