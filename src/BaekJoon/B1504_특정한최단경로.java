package BaekJoon;

import java.util.*;

public class B1504_특정한최단경로 {
    static int N;
    static ArrayList<Node>[] arr;

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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        int E=sc.nextInt();
        arr=new ArrayList[N+1];
        for(int i=1;i<=N;++i) arr[i]=new ArrayList<>();

        while(E-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        int v1=sc.nextInt();
        int v2=sc.nextInt();

        int answer1=0;
        answer1+=dijkstra(1,v1);
        if(answer1==-1) {
            System.out.println(-1);
            return;
        }
        answer1+=dijkstra(v1,v2);
        if(answer1==-1) {
            System.out.println(-1);
            return;
        }
        answer1+=dijkstra(v2,N);
        if(answer1==-1) {
            System.out.println(-1);
            return;
        }

        int answer2=0;
        answer2+=dijkstra(1,v2);
        if(answer2==-1) {
            System.out.println(-1);
            return;
        }
        answer2+=dijkstra(v2,v1);
        if(answer2==-1) {
            System.out.println(-1);
            return;
        }
        answer2+=dijkstra(v1,N);
        if(answer2==-1) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer1<answer2?answer1:answer2);
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        boolean [] visited=new boolean[N+1];
        int [] dist=new int [N+1];
        for(int i=1;i<=N;++i) dist[i]=Integer.MAX_VALUE;
        dist[start]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.end]) continue;
            visited[cur.end]=true;

            for (Node node : arr[cur.end]) {
                if(dist[node.end]>dist[cur.end]+node.weight){
                    dist[node.end]=dist[cur.end]+node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }

        return dist[end]==Integer.MAX_VALUE?-1:dist[end];
    }
}
