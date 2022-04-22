package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2933_미네랄 {

    static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static ArrayList<Node> cluster;
    static int R,C;
    static char [][] map;
    static int [] stick;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();
        map=new char[R][C];
        for(int i=0;i<R;++i){
            String s=sc.next();
            for(int j=0;j<C;++j){
                map[i][j]=s.charAt(j);
            }
        }

        cluster=new ArrayList<>();

        int n=sc.nextInt();
        stick=new int [n];
        for(int i=0;i<n;++i) stick[i]=sc.nextInt();
        for(int i=0;i<n;++i){
            int height= R-stick[i];

            if(i%2==0){
                for(int j=0;j<C;++j){
                    if(map[height][j]=='x'){
                        map[height][j]='.';
                        break;
                    }
                }
            }
            else{
                for(int j=C-1;j>=0;--j){
                    if(map[height][j]=='x'){
                        map[height][j]='.';
                        break;
                    }
                }
            }

            findCluster(); // 내려갈 미네랄 체크, cluster에 저장
            if(cluster.size()!=0) dropCluster();
            cluster.clear();;

        }

        print();
    }

    static void dropCluster(){
        for (Node node : cluster) {
            int x=node.r;
            int y=node.c;

            map[x][y]='.';
        }

        int cnt=0;
        loop:
        for(int i=1;i<R;++i){
            for (Node node : cluster) {
                if(i+node.r>=R || map[i+node.r][node.c]=='x') break loop;
            }
            cnt=i;
        }

        for (Node node : cluster) {
            map[node.r+cnt][node.c]='x';
        }
    }

    static void print(){
        for(int i=0;i<R;++i){
            for(int j=0;j<C;++j){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static void findCluster(){
        cluster=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        boolean [][] visited=new boolean[R][C];

        for(int i=0;i<C;++i){
            if(map[R-1][i]=='x'){
                q.add(new Node(R-1,i));
                visited[R-1][i]=true;
            }
        }

        while (!q.isEmpty()){
            Node cur=q.poll();

            for(int k=0;k<4;++k){
                int x=dx[k]+cur.r;
                int y=dy[k]+cur.c;

                if(0<= x && x<R && 0<=y && y<C && !visited[x][y] && map[x][y]=='x'){
                    q.add(new Node(x,y));
                    visited[x][y]=true;
                }
            }

        }

        for(int i=0;i<R;++i){
            for(int j=0;j<C;++j){
                if(map[i][j]=='x' && !visited[i][j]){
                    cluster.add(new Node(i,j));
                }
            }
        }
    }
}
