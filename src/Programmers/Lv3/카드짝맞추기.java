package Programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 카드짝맞추기 {
    @Test
    public  void test() {
        Assertions.assertEquals(14,solution(new int [][] { {1,0,0,3}, {2,0,0,0}, {0,0,0,2}, {3,0,1,0}},1,0));
//        Assertions.assertEquals(16,solution(new int [][] { {3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1));

    }
    // 1003
    // 2000
    // 0002
    // 3010
    public static ArrayList<int []> orders=new ArrayList<>();
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    public static int solution(int [][] board, int r, int c){
        int answer=Integer.MAX_VALUE;
        int n=0;
        for(int [] row:board){ // 개수 세기
            for(int e:row){
                if(e!=0) n++;
            }
        }
        n/=2; // 같은 카드 2장씩 있으니까 전체 /2
        int [] temp=new int [n];
        for(int i=0;i<n;++i) temp[i]=i+1; // 0:1, 1:2 ,2:3
        orders=new ArrayList<>();
        perm(temp,new int [n],new boolean[n],0,n,n); // 어떤 숫자부터 제거할지 조합
        /*
            1,2,3
            1,3,2
            2,1,3
            2,3,1
            3,1,2
            3,2,1
         */

        for(int [] order:orders){ // 1 2 3
            int total=0;
            int [] point=new int [2]; // 최초 커서 위치(r,c)
            point[0]=r; // 현재위치 r
            point[1]=c; // 현재위치 c
            int [][] cBoard=new int[4][4];
            for(int i=0;i<4;++i){
                for(int j=0;j<4;++j){
                    cBoard[i][j]=board[i][j];
                }
            }

            for(int card:order){ // 조합결과 1
                int cnt=0;
                // 목표 카드 찾기
                cnt+=bfs(cBoard,card,point)+1; // enter
                cBoard[point[0]][point[1]]=0; // 0으로
                System.out.println(point[0]+" "+point[1]);
                // 짝찾기
                cnt+=bfs(cBoard,card,point)+1;
                // 짝찾기 성공
                cBoard[point[0]][point[1]]=0;
                System.out.println(point[0]+" "+point[1]);

                total+=cnt;
            }
            System.out.println("total: "+total);
            System.out.println("-----------------------");
            answer=Math.min(total,answer);
        }

        return answer;

    }

    private static int bfs(int [][]board, int target, int [] point){
        int r=point[0];
        int c=point[1];
        Queue<int []> que=new LinkedList<>();
        boolean [][] visited=new boolean[4][4];

        que.offer(new int []{r,c,0}); // r,c, distance
        visited[r][c]=true;

        while(!que.isEmpty()){
            int [] p=que.poll();
            if(board[p[0]][p[1]]==target){
                point[0]=p[0];
                point[1]=p[1];
                return p[2];
            }

            for(int d=0;d<4;++d){ // right, left, up, down
                int nr=p[0]+dx[d];
                int nc=p[1]+dy[d];

                if(nr>=0 && nr<4 && nc>=0 && nc<4 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    que.offer(new int []{nr,nc,p[2]+1});
                }
            }
            // ctrl+4방향 탐색
            for(int d=0;d<4;++d){
                int [] result=findCard(board,p[0],p[1],d);
                if((result[0]!=p[0] || result[1]!=p[1]) // p가 방향의 제일 끝에 있는 경우는 제외해준다.
                        && !visited[result[0]][result[1]]){
                    visited[result[0]][result[1]]=true;
                    que.offer(new int[]{result[0],result[1],p[2]+1});
                }
            }

        }
        return 0;
    }

    private static int[] findCard(int[][] board, int r, int c, int d) {
        r+=dx[d];
        c+=dy[d];
        while(r>=0 && r<4 && c>=0 && c<4){
            if(board[r][c]!=0){
                return new int[]{r,c};
            }
            r+=dx[d];
            c+=dy[d];
        }
        // 한 방향으로 다 빈 경우
        return new int []{r-dx[d],c-dy[d]};
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        for(int i=0;i<output.length;++i)
        System.out.print(output[i]+" ");
        System.out.println();
        if(depth==r) {
            int [] temp=new int [r];
            for (int i = 0; i < r; ++i) {
                temp[i]=output[i];
            }
            orders.add(temp);
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]==true){
                visited[i]=true;
                output[depth]=arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }


    }
}
