package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {

    @Test
    public void test(){
        Assertions.assertEquals(7,solution(new int [][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }

    boolean [][][] visited;
    int [][] board;
    int n;
    public int solution(int [][] board){
        n=board.length;
        this.board=board;
        this.visited=new boolean[n][n][2];

        int answer=bfs(0,0,0);
        return answer;
    }

    private int bfs(int a, int b, int c) {
        Queue<Node> q=new LinkedList<>();
        visited[a][b][c]=true;
        q.add(new Node(a,b,c,0));

        while(!q.isEmpty()){
            Node cur=q.poll();
            int x=cur.x, y=cur.y,cnt=cur.cnt;

            if(cur.r==0 && x==n-1 && y+1==n-1) return cnt; // 가로
            if(cur.r==1 && x+1==n-1 && y==n-1) return cnt; // 세로

            if(cur.r==0){
                // 이동
                // 오른쪽
                if( move(x,y+2) && !visited[x][y+1][0]){
                    q.add(new Node(x,y+1,0,cnt+1));
                    visited[x][y+1][0]=true;
                }
                // 왼
                if(move(x,y-1) && !visited[x][y-1][0]){
                    q.add(new Node(x,y-1,0,cnt+1));
                    visited[x][y-1][0]=true;
                }
                // 위
                if(move(x-1,y)&&move(x-1,y+1) && !visited[x-1][y][0]){
                    q.add(new Node(x-1,y,0,cnt+1));
                    visited[x-1][y][0]=true;
                }
                // 아래
                if(move(x+1,y) && move(x+1,y+1) && !visited[x+1][y][0]){
                    q.add(new Node(x+1,y,0,cnt+1));
                    visited[x+1][y][0]=true;
                }

                // 회전( 시계 )
                if(move(x+1,y) && move(x+1,y+1)){
                    if(!visited[x][y][1]) {
                        q.add(new Node(x,y,1,cnt+1));
                        visited[x][y][1]=true;
                    }
                    if(!visited[x][y+1][1]){
                        q.add(new Node(x,y+1,1,cnt+1));
                        visited[x][y+1][1]=true;
                    }
                }
                // 회전 ( 반시계 )
                if(move(x-1,y) && move(x-1,y+1)){
                    if(!visited[x-1][y][1]){
                        q.add(new Node(x-1,y,1,cnt+1));
                        visited[x-1][y][1]=true;
                    }
                    if(!visited[x-1][y+1][1]){
                        q.add(new Node(x-1,y+1,1,cnt+1));
                        visited[x-1][y+1][1]=true;
                    }
                }
            }

            if(cur.r==1){
                // 이동
                // 오른
                if(move(x,y+1) && move(x+1,y+1) && !visited[x][y+1][1]){
                    q.add(new Node(x,y+1,1,cnt+1));
                    visited[x][y+1][1]=true;
                }
                // 왼
                if(move(x,y-1) && move(x+1,y-1) && !visited[x][y-1][1]){
                    q.add(new Node(x,y-1,1,cnt+1));
                    visited[x][y-1][1]=true;
                }
                // 위
                if(move(x-1,y) && !visited[x-1][y][1]){
                    q.add(new Node(x-1,y,1,cnt+1));
                    visited[x-1][y][1]=true;
                }
                // 아래
                if(move(x+2,y) && !visited[x+1][y][1]){
                    q.add(new Node(x+1,y,1,cnt+1));
                    visited[x+1][y][1]=true;
                }
                // 회전(시계)
                if(move(x,y+1)&& move(x+1,y+1) ){
                    if(!visited[x][y][0]) {
                        q.add(new Node(x,y,0,cnt+1));
                        visited[x][y][0]=true;
                    }
                    if(!visited[x+1][y][0]){
                        q.add(new Node(x+1,y,0,cnt+1));
                        visited[x+1][y][0]=true;
                    }

                }
                // 회전(반시계)
                if(move(x,y-1) && move(x+1,y-1)){
                    if(!visited[x][y-1][0]){
                        q.add(new Node(x,y-1,0,cnt+1));
                        visited[x][y-1][0]=true;
                    }
                    if(!visited[x+1][y-1][0]){
                        q.add(new Node(x+1,y-1,0,cnt+1));
                        visited[x+1][y-1][0]=true;
                    }
                }
            }
        }
        return -1;

    }
    public boolean check(int x, int y){
        return 0<=x && x<n && 0<=y && y<n;
    }

    public boolean move(int x, int y){
        return check(x,y) && board[x][y]==0;
    }
    public class Node{
        int x,y;
        int r; // 0이면 가로, 1이면 세로
        int cnt;

        public Node(int x, int y, int r, int cnt) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.cnt=cnt;
        }
    }
}
