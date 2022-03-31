package BaekJoon;

import java.io.*;
import java.util.*;

public class B1197_최소스패닝트리 {
    static class Edge implements Comparable<Edge>{
        int a,b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt(); // 정점 개수
        int e=sc.nextInt(); // edge 개수

        parent=new int [v+1];
        for(int i=0;i<=v;++i) parent[i]=i;

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        for(int i=0;i<e;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            pq.add(new Edge(a,b,c));
        }
        int sum=0;
        while (!pq.isEmpty()){
            Edge cur=pq.poll();

            int a=getParent(cur.a);
            int b=getParent(cur.b);

            if(a!=b){
                union(a,b);
                sum+= cur.cost;
            }
        }

        System.out.println(sum);

    }

    static int getParent(int a){
        if(a==parent[a]) return a;

        return parent[a]=getParent(parent[a]);
    }

    static void union(int a, int b){
        a=getParent(a);
        b=getParent(b);

        if(a<b) parent[b]=a;
        else parent[a]=b;
    }
}
