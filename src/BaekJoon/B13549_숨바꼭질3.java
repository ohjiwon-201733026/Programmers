package BaekJoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B13549_숨바꼭질3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        if(k<=n){
            System.out.println(n-k);
            return;
        }
        else{
            int answer=bfs(n,k);
            System.out.println(answer);
        }
    }

    public static int bfs(int start,int target){
        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        pq.add(new Node(start,0));
        boolean [] visited=new boolean[100001];
        visited[start]=true;

        while (!pq.isEmpty()){
            Node cur=pq.poll();
            visited[cur.x]=true;

            if(cur.x==target){
                return cur.cost;
            }

            for(int k=0;k<3;++k){
                int x= cur.x;
                int c=cur.cost;
                if(k==0) { x=x-1; c=c+1; }
                if(k==1) { x=x+1; c=c+1; }
                if(k==2) { x=x*2; }
                if(0<=x && x<=100000 && !visited[x])
                    pq.add(new Node(x,c));
            }
        }

        return -1;
    }

    public static class Node implements Comparable<Node>{
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}
