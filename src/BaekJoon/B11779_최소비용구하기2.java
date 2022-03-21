package BaekJoon;

import java.util.*;

public class B11779_최소비용구하기2 {

    static ArrayList<Node>[] graph;
    static int n,m,count;
    static int [] dist,preCity;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph=new ArrayList[n+1];
        dist=new int [n+1];
        preCity=new int [n+1];

        for(int i=1;i<=n;++i){
            graph[i]=new ArrayList<Node>();
        }

        for(int i=0;i<m;++i){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int cost=sc.nextInt();

            graph[start].add(new Node(end,cost));
        }

        int s=sc.nextInt();
        int e=sc.nextInt();

        dijkstra(s);
        StringBuilder sb=new StringBuilder();
        sb.append(dist[e]+"\n");

        Stack<Integer> stack=new Stack<>();
        stack.add(e);
        while (preCity[e]!=0){
            count+=1;
            stack.push(preCity[e]);
            e=preCity[e];
        }

        sb.append(count+1+"\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra(int start){
        PriorityQueue<Node> q=new PriorityQueue<>();
        boolean [] visited=new boolean[n+1];
        dist=new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.offer(new Node(start,0));
        dist[start]=0;

        while (!q.isEmpty()){
            Node curNode=q.poll();
            int cur=curNode.to;

            if(visited[cur]) continue;
            visited[cur]=true;

            for (Node next : graph[cur]) {
                if(!visited[next.to] && dist[next.to]>dist[cur]+next.cost){
                    dist[next.to]=dist[cur]+next.cost;
                    preCity[next.to]=cur;
                    q.add(new Node(next.to,dist[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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
