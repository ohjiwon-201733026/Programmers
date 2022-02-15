package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

    @Test
    public void test(){
        int [] result=solution(6,4,new int [][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
                {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        Assertions.assertEquals(result[0],4);
        Assertions.assertEquals(result[1],5);
    }

    public boolean [][] visited;
    public int [] dx={0,1,0,-1};
    public int [] dy={1,0,-1,0};
    public int N,M;
    public int [][] pic;
    public int [] solution(int m, int n, int [][] picture){
        pic=picture;
        M=m;
        N=n;
        visited=new boolean[m][n];

        int cnt=0;
        int maxCnt=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(!visited[i][j] && picture[i][j]!=0){
                    cnt++;
                    int x=bfs(i,j,picture[i][j]);
                    System.out.println(picture[i][j]+" "+x);
                    maxCnt=Math.max(maxCnt,x);
                }
            }
        }

        return new int []{cnt,maxCnt};
    }

    public int bfs(int i, int j, int col){
        Queue<int []> q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;
        int cnt=1;
        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<M && 0<=y && y<N){
                    if(!visited[x][y] && pic[x][y]==col){
                        q.add(new int []{x,y});
                        visited[x][y]=true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;

    }
}
