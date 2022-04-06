package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1005_ACMCraft {

    public static int n,k,w;
    public static int [] d;
    public static int [] cost;
    public static ArrayList<Integer> [] topo;
    public static int [] indegree;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-->0){
            n=sc.nextInt();
            k=sc.nextInt();
            d=new int [n];
            cost=new int [n];
            indegree=new int [n];
            topo=new ArrayList[n];

            for(int i=0;i<n;++i) topo[i]=new ArrayList<>();
            for(int i=0;i<n;++i) d[i]=sc.nextInt();

            while (k-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                topo[a-1].add(b-1);
                indegree[b-1]++;
            }

            w=sc.nextInt();
            topologicalSort();
            sb.append(cost[w-1]+"\n");
        }
        System.out.println(sb.toString());

    }

    public static void topologicalSort(){
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;++i){
            if(indegree[i]==0) {
                cost[i]=d[i];
                q.add(new Node(i,d[i]));
            }
        }

        while (!q.isEmpty()){
            Node cur=q.poll();

            for (Integer next : topo[cur.x]) {
                cost[next]=Math.max(cost[next],cost[cur.x]+d[next]);
                indegree[next]--;

                if(indegree[next]==0)  q.add(new Node(next,cur.cost+d[next]));
            }

        }
    }

    static class Node{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }


}
