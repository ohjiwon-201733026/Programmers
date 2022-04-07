package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1005_ACMCraft {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        while (t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int [] d=new int [n+1];
            for(int i=1;i<=n;++i) d[i]=sc.nextInt();
            ArrayList<Integer> [] nodes=new ArrayList[n+1];
            for(int i=0;i<=n;++i) nodes[i]=new ArrayList<>();
            int [] inDegree=new int [n+1];

            while (k-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                nodes[a].add(b);
                inDegree[b]++;
            }

            int w=sc.nextInt();

            int num=topologicalSort(n,d,nodes,inDegree,w);
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int topologicalSort(int n, int [] d, ArrayList<Integer>[] nodes, int [] inDegree, int w){
        Queue<Node> q=new LinkedList<>();
        int [] cost=new int [n+1];
        for(int i=1;i<=n;++i){
            if(inDegree[i]==0){
                q.add(new Node(i,d[i]));
                cost[i]=d[i];
            }
        }

        while (!q.isEmpty()){
            Node cur=q.poll();

            for (int next : nodes[cur.x]) {
                cost[next]=Math.max(cost[next],cur.cost+d[next]);
                inDegree[next]--;

                if(inDegree[next]==0){
                    q.add(new Node(next,cost[next]));
                }
            }
        }

        return cost[w];
    }

    static class Node{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }


}
