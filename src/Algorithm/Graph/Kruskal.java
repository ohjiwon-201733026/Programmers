package Algorithm.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    public static int parents[];

    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int distance;

        public Edge(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance-o.distance;
        }
    }
    public static int getParent(int [] set, int x){
        if(set[x]==x) return x;
        return set[x]=getParent(set,set[x]);
    }

    public static void unionParent(int[] set, int a, int b){
        a=getParent(set,a);
        b=getParent(set,b);
        if(a<b) set[b]=a;
        else set[a]=b;
    }

    public static boolean find(int[] set, int a, int b){
        a=getParent(set,a);
        b=getParent(set,b);
        if(a==b) return true;
        else return false;
    }
    public static void main(String [] args) throws IOException{
        int n=7;
        int m=11;
        int [][] edges=new int [m][3];

        parents=new int [n+1];

        ArrayList<Edge> list=new ArrayList<>();
        list.add(new Edge(1,7,12));
        list.add(new Edge(1,4,28));
        list.add(new Edge(1,2,67));
        list.add(new Edge(1,5,17));
        list.add(new Edge(2,4,24));
        list.add(new Edge(2,5,62));
        list.add(new Edge(3,5,20));
        list.add(new Edge(3,6,37));
        list.add(new Edge(4,7,13));
        list.add(new Edge(5,6,45));
        list.add(new Edge(5,7,73));

        Collections.sort(list);
        int []set=new int [n];

        for(int i=0;i<n;++i) set[i]=i;

        int sum=0;
        for(int i=0;i<list.size();++i){
            if(!find(set,list.get(i).a-1,list.get(i).b-1)){
                sum+=list.get(i).distance;
                unionParent(set,list.get(i).a-1,list.get(i).b-1);
            }
        }
    }
}
