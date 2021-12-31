package BaekJoon;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1238_파티 {
    static int N,M,X;
    static final int INF=Integer.MAX_VALUE;
    static ArrayList<Node>[] arr;
    static int [] tmp;

    static class Node implements Comparable<Node>{
        int end,weight;

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
        X=sc.nextInt();

        arr=new ArrayList[N+1];
        int [] dist=new int[N+1];
        tmp=new int [N+1];

        for(int i=1;i<=N;++i) arr[i]=new ArrayList<>();
        for(int i=1;i<=N;++i) tmp[i]=INF;

        while(M-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int w=sc.nextInt();
            arr[a].add(new Node(b,w));
        }


        for(int i=1;i<=N;++i){
            if(i==X) continue;
            for(int j=1;j<=N;++j) tmp[j]=INF;
            int n=dijkstra(i);
            dist[i]+=n; // i-> X로 가는 길
        }


        for(int i=1;i<=N;++i) tmp[i]=INF;
        dijkstra(X); // x-> i

        for(int i=1;i<=N;++i){
            if(i==X) continue;
            dist[i]+=tmp[i];
        }

        int answer=0;
        for(int i=1;i<=N;++i){
            answer=Math.max(answer,dist[i]);
        }

        System.out.println(answer);

    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        tmp[start]=0;
        boolean [] visited=new boolean[N+1];

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int curE=cur.end;

            if(visited[curE]) continue;
            visited[curE]=true;

            for (Node node : arr[curE]) {
                if(tmp[node.end]>tmp[curE]+ node.weight){
                    tmp[node.end]=tmp[curE]+ node.weight;
                    pq.add(new Node(node.end,tmp[node.end]));
                }
            }
        }



        return tmp[X];
    }
}
