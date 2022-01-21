package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 합승택시요금 {
    @Test
    public void test(){
        Assertions.assertEquals(82,
                solution(6,4,6,2,new int [][]{
                        {4, 1, 10},
                        {3, 5, 24},
                        {5, 6, 2},
                        {3, 1, 41},
                        {5, 1, 24},
                        {4, 6, 50},
                        {2, 4, 66},
                        {2, 3, 22},
                        {1, 6, 25}
                }));
    }
    PriorityQueue<Node> pq=new PriorityQueue<>();
    static class Node implements Comparable<Node>{
        int e,w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
    public int[] dijkstra(int start){

        int [] d=new int [this.n+1];
        for(int i=0;i<d.length;++i) d[i]=Integer.MAX_VALUE;
        boolean [] visited=new boolean[this.n+1];

        pq.add(new Node(start,0));
        d[start]=0;

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.e]) continue;
            visited[cur.e]=true;


            for (Node node : list[cur.e]) {
                if(d[node.e]>d[cur.e]+ node.w){
                    d[node.e]=d[cur.e]+node.w;
                    pq.add(new Node(node.e,d[node.e]));
                }

            }

        }

        return d;

    }
    static int n;
    static ArrayList<Node>[] list;
    public int solution(int n,int s, int a, int b, int [][] fares){
        this.n=n;
        list=new ArrayList[n+1];

        for(int i=1;i<=n;++i) list[i]=new ArrayList<>();


        for(int i=0;i<fares.length;++i){
            int x=fares[i][0];
            int y=fares[i][1];
            int w=fares[i][2];

            list[x].add(new Node(y,w));
            list[y].add(new Node(x,w));
        }

        int [] sDist=dijkstra(s);
        int [] aDist=dijkstra(a);
        int [] bDist=dijkstra(b);
        int answer=Integer.MAX_VALUE;
        for(int i=1;i<=n;++i){
            answer=Math.min(sDist[i]+aDist[i]+bDist[i],answer);
        }

        return answer;
    }
}
