package Programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {

    @Test
    public void test(){
        Assertions.assertEquals(7,solution(new int [][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }

    static boolean [][][] visited;
    static int N;
    static int [][] board;
    public int solution(int [][] board){
        this.board=board;
        N=board.length;
        visited=new boolean [N][N][2];

        int answer=bfs(0,0);
        return answer;
    }

    private boolean check(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    private boolean move(int x, int y){
        return check(x,y) && board[x][y]==0;
    }


    private int bfs(int i, int j){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(i,j,0,0));
        visited[i][j][0]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();
            int x=cur.x,y=cur.y,r=cur.r,c=cur.cnt;

            if(cur.r==0 && cur.x==N-1 && cur.y+1==N-1) return cur.cnt;
            if(cur.r==1 && cur.x+1==N-1 && cur.y==N-1) return cur.cnt;
            
            
            if(cur.r==0){ // 가로
                // 이동
                // 오른쪽
                if(move(x,y+2) && !visited[x][y+1][0]){
                    q.add(new Node(x,y+1,0,c+1));
                    visited[x][y+1][0]=true;
                }
                // 왼
                if(move(x,y-1) && !visited[x][y-1][0]){
                    q.add(new Node(x,y-1,0,c+1));
                    visited[x][y-1][0]=true;
                }
                // 위
                if(move(x-1,y) && move(x-1,y+1) && !visited[x-1][y][0]){
                    q.add(new Node(x-1,y,0,c+1));
                    visited[x-1][y][0]=true;
                }
                // 아래
                if(move(x+1,y) && move(x+1,y+1)&&!visited[x+1][y][0]){
                    q.add(new Node(x+1,y,0,c+1));
                    visited[x+1][y][0]=true;
                }

                // 회전
                if(move(x+1,y) && move(x+1,y+1)){
                    if(!visited[x][y][1]){
                        q.add(new Node(x,y,1,c+1));
                        visited[x][y][1]=true;
                    }
                    if(!visited[x][y+1][1]){
                        q.add(new Node(x,y+1,1,c+1));
                        visited[x][y+1][1]=true;
                    }
                }
                
                if(move(x-1,y) && move(x-1,y+1)){
                    if(!visited[x-1][y][1]){
                        q.add(new Node(x-1,y,1,c+1));
                        visited[x-1][y][1]=true;
                    }
                    if(!visited[x-1][y+1][1]){
                        q.add(new Node(x-1,y+1,1,c+1));
                        visited[x-1][y+1][1]=true;
                    }
                }
            }
            
            if(cur.r==1){ // 세로
                // 이동
                // 오른
                if(move(x,y-1) && move(x+1,y-1) && !visited[x][y-1][1]){
                    q.add(new Node(x,y-1,1,c+1));
                    visited[x][y-1][1]=true;
                }
                // 왼
                if(move(x,y+1) && move(x+1,y+1) && !visited[x][y+1][1]){
                    q.add(new Node(x,y+1,1,c+1));
                    visited[x][y+1][1]=true;
                }
                // 위
                if(move(x-1,y) && !visited[x-1][y][1]){
                    q.add(new Node(x-1,y,1,c+1));
                    visited[x-1][y][1]=true;
                }
                // 아래
                if(move(x+2,y) && !visited[x+1][y][1]){
                    q.add(new Node(x+1,y,1,c+1));
                    visited[x+1][y][1]=true;
                }

                // 회전
                if(move(x,y+1) && move(x+1,y+1)){
                    if(!visited[x][y][0]){
                        q.add(new Node(x,y,0,c+1));
                        visited[x][y][0]=true;
                    }
                    if(!visited[x+1][y][0]){
                        q.add(new Node(x+1,y,0,c+1));
                        visited[x+1][y][0]=true;
                    }
                }

                if(move(x,y-1) && move(x+1,y-1)){
                    if(!visited[x][y-1][0]){
                        q.add(new Node(x,y-1,0,c+1));
                        visited[x][y-1][0]=true;
                    }
                    if(!visited[x+1][y-1][0]){
                        q.add(new Node(x+1,y-1,0,c+1));
                        visited[x+1][y-1][0]=true;
                    }
                }
            }

        }

        return -1;
    }

    class Node{
        int x,y,r;
        int cnt;

        public Node(int x, int y, int r,int cnt) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.cnt=cnt;
        }
    }
}
