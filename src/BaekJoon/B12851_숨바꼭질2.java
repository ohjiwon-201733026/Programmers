package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851_숨바꼭질2 {
    static int n,k;
    static int min,cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        min=Integer.MAX_VALUE;
        cnt=0;

        if(k<n){
            System.out.println(n-k);
            System.out.println(1);
        }
        else{
            bfs(n);
            System.out.println(min);
            System.out.println(cnt);

        }


    }

    public static void bfs(int start){
        Queue<Node> q=new LinkedList<>();
        boolean [] visited=new boolean[100001];

        q.add(new Node(start,0));
        visited[start]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();
            visited[cur.num]=true;

            if(cur.num==k){
                if(min>cur.cnt) {
                    min= cur.cnt;
                    cnt=0;
                }
                if(min==cur.cnt) cnt++;
                continue;
            }


            for(int i=0;i<3;++i){
                int next=cur.num;
                if(i==0) next+=1;
                if(i==1) next-=1;
                if(i==2) next*=2;

                if(0<=next && next<=100000 && !visited[next]){
                    q.add(new Node(next, cur.cnt+1));
                }
            }

        }
    }

    public static class Node{
        int num,cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
