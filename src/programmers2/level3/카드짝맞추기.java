package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 카드짝맞추기 {

    @Test
    public void test(){
        Assertions.assertEquals(14,solution(new int [][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1,0));
        Assertions.assertEquals(16,solution(new int [][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1));
    }

    static ArrayList<String> orders;
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    public int solution(int [][] board, int r, int c){
        int answer=Integer.MAX_VALUE;
        orders=new ArrayList<>();
        int n=0;
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                if(board[i][j]!=0) n++;
            }
        }
        n/=2;
        int [] arr=new int [n];
        for(int i=0;i<n;++i) arr[i]=i+1;
        boolean [] visited=new boolean[n];
        int [] output=new int [n];
        perm(arr,output,visited,0,n,n);

        for (String order : orders) {
            int total=0;
            int [] point={r,c}; // 현재 위치
            int [][] cBoard=new int [4][4];

            for(int i=0;i<4;++i){
                for(int j=0;j<4;++j){
                    cBoard[i][j]=board[i][j];
                }
            }

            for(int i=0;i<order.length();++i){
                int cnt=0;
                int target=order.charAt(i)-'0';
                cnt+=bfs(cBoard,target,point)+1;
                cBoard[point[0]][point[1]]=0;
                System.out.println(point[0]+" "+point[1]);
                cnt+=bfs(cBoard,target,point)+1;
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

    private static int bfs(int [][] cBoard, int target, int [] point){
        Queue<int []> q=new LinkedList<>();
        boolean [][] visited=new boolean[4][4];
        int r=point[0];
        int c=point[1];
        q.add(new int []{r,c,0});
        visited[r][c]=true;

        while(!q.isEmpty()){
            int [] cur=q.poll();

            if(cBoard[cur[0]][cur[1]]==target){
                point[0]=cur[0];
                point[1]=cur[1];
                return cur[2];
            }

            for(int d=0;d<4;++d){
                int x=cur[0]+dx[d];
                int y=cur[1]+dy[d];

                if(0<=x && x<4 && 0<=y && y<4 && !visited[x][y]){
                    visited[x][y]=true;
                    q.add(new int []{x,y,cur[2]+1});
                }
            }

            // ctrl+방향키
            for(int d=0;d<4;++d){
                int [] result=findCard(cBoard,cur[0],cur[1],d);
                if(result[0]!=cur[0] || result[1]!=cur[1] && !visited[result[0]][result[1]]){
                    visited[result[0]][result[1]]=true;
                    q.offer(new int []{result[0],result[1],cur[2]+1});
                }
            }
        }
        return 0;
    }

    private static int [] findCard(int [][] cBoard,int r, int c, int d){
        r+=dx[d];
        c+=dy[d];
        while (0<=r && r<4 && 0<=c && c<4){
            if(cBoard[r][c]!=0) return new int []{r,c};
            r+=dx[d];
            c+=dy[d];
        }

        return new int []{r-dx[d],c-dy[d]};
    }



    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < r; ++i) {
                sb.append(output[i]);
            }
            orders.add(sb.toString());
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
