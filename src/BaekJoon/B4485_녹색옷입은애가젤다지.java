package BaekJoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B4485_녹색옷입은애가젤다지 {
    static int [][] map;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=1;
        StringBuilder sb=new StringBuilder();
        while(true){
            int n=sc.nextInt();

            if(n==0) break;
            map=new int [n][n];

            for(int j=0;j<n;++j){
                for(int k=0;k<n;++k){
                    map[j][k]=sc.nextInt();
                }
            }

            int ans=bfs(n);

            sb.append("Problem "+i+": "+ans+"\n");

            i++;
        }
        System.out.println(sb.toString());
    }

    static int bfs(int n){
        PriorityQueue<Point> pq=new PriorityQueue<Point>();
        boolean [][] visited=new boolean[n][n];
        visited[0][0]=true;
        pq.add(new Point(0,0,map[0][0]));

        while(!pq.isEmpty()){
            Point p=pq.poll();


            if(p.x==n-1 && p.y==n-1){
                return p.cnt;
            }

            for(int k=0;k<4;++k){
                int x= p.x+dx[k];
                int y=p.y+dy[k];


                if(0<=x && x<n && 0<=y && y<n && !visited[x][y]){
                    pq.add(new Point(x,y,p.cnt+map[x][y]));
                    visited[x][y]=true;
                }
            }
        }
        return 0;
    }

    static class Point implements Comparable<Point>{
        int x,y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Point o) {
            return this.cnt-o.cnt;
        }
    }
}
