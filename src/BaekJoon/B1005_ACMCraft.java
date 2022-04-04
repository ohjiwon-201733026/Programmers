package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1005_ACMCraft {


    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (tc-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int [] d=new int [n+1];
            for(int i=1;i<=n;++i) d[i]=sc.nextInt();
            ArrayList<Integer> [] arr=new ArrayList[n+1];
            for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();
            int [] inDegree=new int [n+1];
            while (k-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr[a].add(b);
                inDegree[b]++;
            }

            int w=sc.nextInt();

            int num=topologySort(w,inDegree,arr,d,n);
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
    }

    static int topologySort(int w, int [] inDegree,ArrayList<Integer> [] arr, int [] d, int n){
        Queue<Node> q=new LinkedList<>();
        int [] cost=new int [n+1];
        for(int i=1;i<=n;++i){
            if(inDegree[i]==0){
                q.add(new Node(i,d[i]));
                cost[i]=d[i];
            }
        }
        int answer=0;

        while (!q.isEmpty()){
            Node cur=q.poll();

            for (Integer next : arr[cur.x]) {
                cost[next]=Math.max(cost[cur.x]+d[next],cost[next]);
                inDegree[next]--;
                if(inDegree[next]==0)
                q.add(new Node(next,cur.cost+d[next]));
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
