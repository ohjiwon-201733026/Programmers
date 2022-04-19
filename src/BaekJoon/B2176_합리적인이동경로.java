package BaekJoon;

import java.util.*;

public class B2176_합리적인이동경로 {
    static int n,m;
    static ArrayList<Node> [] arr;
    static int [] dist;
    static final int INF=Integer.MAX_VALUE;
    static int [] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new ArrayList[n+1];
        dist=new int[n+1];
        dp=new int [n+1];

        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        while (m-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        dijkstra(2);
        Arrays.fill(dp,-1);

        System.out.println(go(1));
    }

    static int go(int cur){
        if(dp[cur]!=-1) return dp[cur];
        if(cur==2) return dp[2]=1;
        dp[cur]=0;
        for (Node next : arr[cur]) {
            if(dist[next.end]<dist[cur]){
                dp[cur]+=go(next.end);
            }
        }

        return dp[cur];

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        Arrays.fill(dist,INF);
        dist[start]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(dist[cur.end]<cur.cost) continue;

            for (Node next : arr[cur.end]) {
                if(dist[next.end]>dist[cur.end]+next.cost){
                    dist[next.end]=dist[cur.end]+ next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost-this.cost;
        }
    }
}
