package BaekJoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기 {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        char [][] map=new char[n][m];

        for(int i=0;i<n;++i){
            String str=sc.next();
            for(int j=0;j<m;++j){
                map[i][j]=str.charAt(j);
            }
        }

        int [] dx={0,1,0,-1};
        int [] dy={1,0,-1,0};

        boolean [][][] visited=new boolean[n][m][2];
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(0,0,1,false));
        visited[0][0][0]=true;

        while (!q.isEmpty()){
            Node cur=q.poll();

            if(cur.x==n-1 && cur.y==m-1){
                System.out.println(cur.d);
                return;
            }


            for(int k=0;k<4;++k){
                int x=cur.x+dx[k];
                int y=cur.y+dy[k];

                if(x<0 || x>=n || y<0 || y>=m) continue;

                if(map[x][y]=='0'){
                    if(cur.destroyed && !visited[x][y][1]){
                        q.add(new Node(x,y,cur.d+1,cur.destroyed));
                        visited[x][y][1]=true;
                    }

                    if(!cur.destroyed && !visited[x][y][0]){
                        q.add(new Node(x,y,cur.d+1,cur.destroyed));
                        visited[x][y][0]=true;
                    }
                }

                if(map[x][y]=='1'){
                    if(!cur.destroyed && !visited[x][y][1]){
                        q.add(new Node(x,y,cur.d+1,true));
                        visited[x][y][1]=true;
                    }
                }
            }

        }
        System.out.println(-1);

    }

    static class Node{
        int x,y,d;
        boolean destroyed;


        public Node(int x, int y, int d, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.destroyed = destroyed;
        }
    }

}
