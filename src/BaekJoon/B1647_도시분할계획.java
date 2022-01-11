package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1647_도시분할계획 {

    static int [] parent;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        ArrayList<Edge> list=new ArrayList<>();
        parent=new int [N+1];
        for(int i=1;i<=N;++i) parent[i]=i;

        while(M-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a<b) list.add(new Edge(a,b,c));
            else list.add(new Edge(b,a,c));
        }

        Collections.sort(list);
        int max=0;
        int sum=0;
        for(int i=0;i<list.size();++i){
            Edge cur=list.get(i);
            if(!isSameParent(cur.s,cur.e)){
                union(cur.s,cur.e);
                sum+=cur.w;
                max=Math.max(max,cur.w);
            }
        }

        System.out.println(sum-max);


    }

    static int getParent(int x){
        if(x==parent[x]) return parent[x];

        return parent[x]=getParent(parent[x]);

    }
    static void union(int x, int y){
        x=getParent(x);
        y=getParent(y);

        if(x!=y){
            parent[y]=x;
        }
    }

    static boolean isSameParent(int x, int y){
        x=getParent(x);
        y=getParent(y);

        return x==y;
    }

    static class Edge implements Comparable<Edge>{
        int s,e,w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
}
