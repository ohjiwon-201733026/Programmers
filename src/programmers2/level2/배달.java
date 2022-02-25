package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(5,new int [][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
    }

    static ArrayList<Node>[] map;
    class Node implements Comparable<Node>{
        int e,d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d-o.d;
        }
    }
    public int solution(int n, int [][] road, int k){
        map=new ArrayList[n+1];

        for(int i=1;i<=n;++i) map[i]=new ArrayList<>();

        for (int[] a : road) {
            int x=a[0],y=a[1],d=a[2];
            map[x].add(new Node(y,d));
            map[y].add(new Node(x,d));
        }

        return dijkstra(1,n,k);
    }

    public int dijkstra(int start,int n,int k){
        int [] d=new int [n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean [] visited=new boolean[n+1];
        pq.add(new Node(start,0));
        d[start]=0;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.e]) continue;
            visited[cur.e]=true;

            for (Node node : map[cur.e]) {
                if(!visited[node.e] && d[node.e]>d[cur.e]+node.d){
                    d[node.e]=d[cur.e]+node.d;
                    pq.add(new Node(node.e,d[node.e]));
                }
            }
        }
        int cnt=0;
        for (int i=1;i<d.length;++i) {
            if(d[i]<=k) cnt++;
        }

        return cnt;
    }
}
