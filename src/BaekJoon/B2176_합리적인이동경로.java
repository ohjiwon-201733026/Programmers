package BaekJoon;

import java.util.*;

public class B2176_합리적인이동경로 {
    static int n;
    static ArrayList<Node> [] arr;
    static int [] dist;
    static int [] dp;
    static final int INF=987654321;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int m=sc.nextInt();

        arr=new ArrayList[n+1];
        dist=new int [n+1];
        dp=new int [n+1];
        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();
        for(int i=0;i<m;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        Arrays.fill(dist,INF);
        Arrays.fill(dp,-1);
        dijkstra(2);


        System.out.println(bfs(1));
    }
    static int bfs(int cur){
        if(dp[cur]!=-1) return dp[cur];
        if(cur==2) return dp[cur]=1;

        dp[cur]=0;

        for (Node next : arr[cur]) {
            if(dist[cur]>dist[next.e]){
                dp[cur]+=bfs(next.e);
            }
        }

        return dp[cur];
    }

    static void dijkstra(int num){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(num,0));
        dist[num]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();
            int now=cur.e;
            int d=cur.c;

            if(d>dist[now]) continue;

            for (Node node : arr[cur.e]) {
                if( dist[node.e]>dist[cur.e]+ node.c){
                    dist[node.e]=dist[cur.e]+ node.c;
                    pq.add(new Node(node.e,dist[node.e]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int e,c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return o.c-this.c;
        }
    }
}
