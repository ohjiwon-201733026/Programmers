package BaekJoon;

import java.util.*;

public class B11779_최소비용구하기2 {


    static ArrayList<Node> [] arr;
    static int [] preCity, dist;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int m=sc.nextInt();

        arr=new ArrayList[n+1];
        preCity=new int [n+1];
        dist=new int [n+1];

        for(int i=0;i<=n;++i){
            arr[i]=new ArrayList<>();
        }

        while (m-->0){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int cost=sc.nextInt();
            arr[start].add(new Node(end,cost));
        }

        int s=sc.nextInt();
        int e=sc.nextInt();

        dijkstra(s);

        StringBuilder sb=new StringBuilder();
        sb.append(dist[e]+"\n");

        Stack<Integer> stack=new Stack<>();
        stack.push(e);

        int count=1;
        while (preCity[e]!=0){
            stack.push(preCity[e]);
            count++;
            e=preCity[e];
        }

        sb.append(count+"\n");

        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb.toString());

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean [] visited=new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        pq.add(new Node(start,0));
        dist[start]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.to]) continue;
            visited[cur.to]=true;

            for (Node next : arr[cur.to]) {
                if(!visited[next.to] && dist[next.to]>dist[cur.to]+next.cost){
                    dist[next.to]=dist[cur.to]+next.cost;
                    preCity[next.to]=cur.to;
                    pq.add(new Node(next.to, dist[next.to]));
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
