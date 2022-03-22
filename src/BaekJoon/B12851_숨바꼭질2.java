package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851_숨바꼭질2 {

    static int n,k;
    static int answer;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        answer=0;
        if(k<n) {
            System.out.println(n-k);
            System.out.println(1);
        }
        else{
            bfs(n);
            System.out.println(min);
            System.out.println(cnt);
        }
    }
    static int min,cnt;
    static void bfs(int start){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(start,0));
        min=Integer.MAX_VALUE;
        cnt=0;
        boolean [] visited=new boolean[100001];
//        visited[start]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();
            visited[cur.n]=true;

            if(cur.n==k){
                if(min>cur.cnt) min=cur.cnt;
                if(min==cur.cnt) cnt++;
                continue;
            }

            for(int i=0;i<3;++i){
                int next=cur.n;
                if(i==0) next-=1;
                if(i==1) next+=1;
                if(i==2) next*=2;

                if(0<=next && next<=100000 && !visited[next]){
                    q.add(new Node(next,cur.cnt+1));
                }
            }

        }
    }

    static class Node{
        int n,cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
