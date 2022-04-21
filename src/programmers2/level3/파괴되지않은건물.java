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
       int [][] sum=new int [n+1][m+1];

       for (int[] arr : skill) {
           int type = arr[0] == 1 ? -1 : 1;
           int r1 = arr[1], c1 = arr[2];
           int r2 = arr[3], c2 = arr[4];
           int degree = type * arr[5];

           sum[r1][c1] += degree;
           sum[r1][c2 + 1] -= degree;
           sum[r2+1][c1]-=degree;
           sum[r2+1][c2+1]+=degree;
       }

       for(int i=0;i<=n;++i){
           for(int j=1;j<=m;++j){
               sum[i][j]+=sum[i][j-1];
           }
       }

       for(int i=1;i<=n;++i){
           for(int j=0;j<=m;++j){
               sum[i][j]+=sum[i-1][j];
           }
       }

       for(int i=0;i<n;++i){
           for(int j=0;j<m;++j){
               if(sum[i][j]+board[i][j]>0) answer++;
           }
       }



       return answer;
   }


}
