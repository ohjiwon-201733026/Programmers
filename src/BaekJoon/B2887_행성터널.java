package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B2887_행성터널 {
    static class Point{
        int num;
        int x,y,z;

        public Point(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start,end,weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight-o.weight;
        }
    }
    static int [] parent;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Point [] points=new Point[N];
        for(int i=0;i<N;++i){
            int x= sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();

            points[i]=new Point(i,x,y,z);
        }

        edgeList=new ArrayList<>();

        Arrays.sort(points,(p1,p2)->p1.x-p2.x);
        for(int i=0;i<N-1;++i){
            int weight=Math.abs(points[i].x-points[i+1].x);
            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        Arrays.sort(points,(p1,p2)->p1.y-p2.y);
        for(int i=0;i<N-1;++i){
            int weight=Math.abs(points[i].y-points[i+1].y);
            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        Arrays.sort(points,(p1,p2)->p1.z-p2.z);
        for(int i=0;i<N-1;++i){
            int weight=Math.abs(points[i].z-points[i+1].z);
            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        parent=new int [N];
        for(int i=0;i<N;++i) parent[i]=i;

        Collections.sort(edgeList);

        int ans=0;
        for(int i=0;i<edgeList.size();++i){
            Edge edge=edgeList.get(i);

            if(find(edge.start)!=find(edge.end)){
                ans+=edge.weight;
                union(edge.start,edge.end);
            }
        }

        System.out.println(ans);
    }

    static int find(int x){
        if(x==parent[x]) return x;

        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y){
        x=find(x);
        y=find(y);

        if(x!=y){
            parent[y]=x;
        }
    }
}
