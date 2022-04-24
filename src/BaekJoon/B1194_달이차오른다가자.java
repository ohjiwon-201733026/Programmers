package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1194_달이차오른다가자 {

   static int [] dx={-1,1,0,0};
   static int [] dy={0,0,-1,1};
   static char [][] map;
   static boolean [][][] visited;
   static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        map=new char[n][m];
        visited=new boolean[n][m][64];

        for(int i=0;i<n;++i){
            map[i]=br.readLine().toCharArray();

            for(int j=0;j<m;++j){
                if(map[i][j]=='0'){
                    start=new Node(i,j,0,0);
                }
            }
        }
        System.out.println((1<<('b'-'a')));

        bfs(start.x,start.y);
    }

    static void bfs(int x, int y){
        Queue<Node> q=new LinkedList<>();

        q.add(new Node(x,y,0,0));
        visited[x][y][0]=true;

        while (!q.isEmpty()){
            Node tmp=q.poll();
            int count=tmp.count;
            int key = tmp.key;

            if(map[tmp.x][tmp.y]=='1'){
                System.out.println(tmp.count);
                return;
            }

            for(int i=0;i<4;++i){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];

                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length) continue;

                if(map[nx][ny]=='#' || visited[nx][ny][key]) continue;

                // 열쇠일 때
                if(map[nx][ny]-'a'>=0 && map[nx][ny]-'a'<6){
                    int tmpKey=(1<<(map[nx][ny]-'a')) | key; // 1을 옆으로 x칸 옮기기 + key랑 합치기

                    if(!visited[nx][ny][tmpKey]){
                        visited[nx][ny][tmpKey]=true;
                        q.add(new Node(nx,ny,count+1,tmpKey));
                    }
                }
                // 문일 때
                else if(map[nx][ny]-'A'>=0 && map[nx][ny]-'A'<6){
                    int tmpDoor=(1<<(map[nx][ny]-'A')) & key;

                    if(tmpDoor>0){
                        visited[nx][ny][key]=true;
                        q.add(new Node(nx,ny,count+1,key));
                    }
                }
                // 그냥 빈칸일때
                else{
                    visited[nx][ny][key]=true;
                    q.add(new Node(nx,ny,count+1,key));
                }
            }
        }
        System.out.println(-1);
    }

    static class Node{
        int x,y,count,key;

        public Node(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }
}
