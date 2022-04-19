package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 파괴되지않은건물 {

    @Test
    public void test(){
        int [][] board={{1,2,3},{4,5,6},{7,8,9}};
        int [][] skill={{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        Assertions.assertEquals(6,solution(board,skill));
    }

   public int solution(int [][] board, int [][] skill){
        int answer=0;
        int n=board.length;
        int m=board[0].length;
        int [][] prefix_arr=new int [n+1][m+1];

       for (int[] row : skill) {
           int type=row[0];
           int degree=type==1?-row[5]:row[5];
           int r1=row[1];
           int c1=row[2];
           int r2=row[3];
           int c2=row[4];

           prefix_arr[r1][c1]+=degree;
           prefix_arr[r1][c2+1]+=-degree;
           prefix_arr[r2+1][c1]+=-degree;
           prefix_arr[r2+1][c2+1]+=degree;
       }

       for(int y=1;y<n;++y){
           for(int x=0;x<m;++x){
               prefix_arr[y][x]+=prefix_arr[y-1][x];
           }
       }

       for(int x=1;x<m;++x){
           for(int y=0;y<n;++y){
               prefix_arr[y][x]+=prefix_arr[y][x-1];
           }
       }

       for(int i=0;i<n;++i){
           for(int j=0;j<m;++j){
               if(board[i][j]+prefix_arr[i][j]>0) answer++;
           }
       }

       return answer;
   }


}
