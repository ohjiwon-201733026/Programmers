package BaekJoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B13913_숨바꼭질4 {
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        if(n>=k){
            System.out.println(n-k);
            while (n>k){
                System.out.print(n+" ");
                n--;
            }
            System.out.println(n);
        }
        else{
            bfs(n,k);

        }
    }

    public static void bfs(int start, int target){
        Queue<Node> pq=new LinkedList<>();
        pq.add(new Node(start,0,start+" "));
        boolean [] visited=new boolean[100001];
        visited[start]=true;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(cur.x==target){
                System.out.println(cur.cost);
                System.out.println(cur.route);
            }

            for(int k=0;k<3;++k){
                int x=cur.x;
                if(k==0) x=x-1;
                if(k==1) x=x+1;
                if(k==2) x=2*x;

                if(0<=x && x<=100000 && !visited[x]){
                    pq.add(new Node(x,cur.cost+1,cur.route+x+" "));
                    visited[x]=true;
                }
            }
        }
    }

    static class Node {
        int x, cost;
        String route;

        public Node(int x, int cost,String route) {
            this.x = x;
            this.cost = cost;
            this.route=route;
        }


    }
}
