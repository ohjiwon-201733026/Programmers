package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11559_PuyoPuyo {
    static char [][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        map=new char[12][6];

        for(int i=0;i<12;++i){
            String str=sc.next();
            for(int j=0;j<6;++j){
                map[i][j]=str.charAt(j);
            }
        }

        int answer=0;
        while (true){
            visited=new boolean[12][6];
            boolean flag=false;

            for(int i=0;i<12;++i){
                for(int j=0;j<6;++j){
                    if(!visited[i][j] && map[i][j]!='.'){
                        int num=bfs(i,j,map[i][j]);
                        if(num>=4){ // 4개 이상 터지는 경우
                            clearPuyo(i,j,map[i][j]);
                            flag=true;
                        }
                    }
                }
            }

            if(!flag) break;
            answer++;
            downPuyo();
        }

        System.out.println(answer);


    }

    static void downPuyo(){

        for(int i=0;i<12;++i){
            for(int j=0;j<6;++j){
                if(map[i][j]=='.'){
                    for(int k=i;k>0;--k){
                        map[k][j]=map[k-1][j];
                        map[k-1][j]='.';
                    }
                }
            }
        }

    }

    static void printPuyo(){
        for(int i=0;i<12;++i){
            for(int j=0;j<6;++j) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void clearPuyo(int i, int j, char color){
        Queue<int [] >q=new LinkedList<>();
        q.add(new int []{i,j});
        boolean [][] check=new boolean[12][6];
        check[i][j]=true;
        map[i][j]='.';

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<12 && 0<=y && y<6 && !check[x][y] && map[x][y]==color){
                    q.add(new int []{x,y});
                    check[x][y]=true;
                    map[x][y]='.';
                }
            }
        }


    }
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static int bfs(int i, int j, char color){
        Queue<int [] >q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;
        int cnt=1;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<12 && 0<=y && y<6 && !visited[x][y] && map[x][y]==color){
                    q.add(new int []{x,y});
                    cnt++;
                    visited[x][y]=true;
                }
            }
        }

        return cnt;

    }
}
