package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226_이모티콘 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();

        bfs(s);

    }

    public static void bfs(int target){
        Queue<Node> pq=new LinkedList<>();
        pq.add(new Node(1,0,0));
        boolean [][] visited=new boolean[1001][1001];
        visited[1][0]=true;

        while (!pq.isEmpty()){
            Node cur=pq.poll();

            if(cur.monitor==target){
                System.out.println(cur.cnt);
                return;
            }

            for(int i=0;i<3;++i){
                int x=cur.monitor;
                int y=cur.clipboard;

                if(i==0){ y=cur.monitor; }
                if(i==1){ x= cur.monitor+ cur.clipboard; }
                if(i==2){ x= cur.monitor-1; }

                if(0<=x && x<=1000 && 0<=y && y<=1000 && !visited[x][y]){
                    if(cur.clipboard==0 && i==1) continue;
                    if(cur.monitor==0 && i==2) continue;
                    pq.add(new Node(x,y, cur.cnt+1));
                    visited[x][y]=true;
                }
            }
        }
    }

    static class Node{
        int monitor;
        int clipboard;
        int cnt;

        public Node(int monitor, int clipboard, int cnt) {
            this.monitor = monitor;
            this.clipboard = clipboard;
            this.cnt=cnt;
        }
    }
}
