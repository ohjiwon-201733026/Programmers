package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    @Test
    public void test(){
        Assertions.assertEquals(11,solution(new int [][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        Assertions.assertEquals(-1,solution(new int [][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

    static boolean [][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static int n,m;
    public int solution(int [][] maps){
        n=maps.length;
        m=maps[0].length;
        visited=new boolean[n][m];


        int answer=bfs(0,0,maps);
        return answer;
    }

    public int bfs(int i,int j, int [][] maps){
        Queue<int [] > q=new LinkedList<>();
        q.add(new int []{i,j,1});
        visited[i][j]=true;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            if(cur[0]==n-1 && cur[1]==m-1){
                return cur[2];
            }

            for(int k=0;k<4;++k){
                int x= dx[k]+cur[0];
                int y= dy[k]+cur[1];

                if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && maps[x][y]!=0){
                    q.add(new int []{x,y,cur[2]+1});
                    visited[x][y]=true;
                }
            }
        }

        return -1;
    }
}
