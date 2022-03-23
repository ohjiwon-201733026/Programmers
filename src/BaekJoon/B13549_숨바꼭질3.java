package BaekJoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B13549_숨바꼭질3 {

    static int n,k;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        if(n>k){
            System.out.println(n-k);
        }
        else{
            bfs(n);
        }
    }

    public static void bfs(int start){
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.offer(new Node(start,0));

        boolean [] visited=new boolean[100001];
        visited[start]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();
            visited[cur.num]=true;

            if(cur.num==k){
                System.out.println(cur.cnt);
                return;
            }

            for(int i=0;i<3;++i){
                int next=cur.num;
                if(i==0) next-=1;
                if(i==1) next+=1;
                if(i==2) next*=2;

                if(0<=next && next<=100000 && !visited[next]){
                    if(i==0 || i==1) q.add(new Node(next,cur.cnt+1));
                    else if(i==2) q.add(new Node(next,cur.cnt));
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        int num,cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt-o.cnt;
        }
    }
}
