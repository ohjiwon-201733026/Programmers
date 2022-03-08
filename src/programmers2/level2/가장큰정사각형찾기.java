package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 가장큰정사각형찾기 {

    @Test
    public void test(){
        Assertions.assertEquals(9,solution(new int [][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        Assertions.assertEquals(4,solution(new int [][]{{0,0,1,1},{1,1,1,1}}));
    }

    public int solution(int [][] board){
        int [][] dp=new int [board.length][board[0].length];

        if(board.length==1 && board[0].length==1) return board[0][0];

        for(int i=0;i<board.length;++i){
            dp[i][0]=board[i][0];
        }
        for(int i=0;i<board[0].length;++i){
            dp[0][i]=board[0][i];
        }
        int max=0;
        for(int i=1;i<board.length;++i){
            for(int j=1;j< board[0].length;++j){
                if(board[i][j]!=0)
                dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+board[i][j];
                max=Math.max(max,dp[i][j]);
            }
        }


        return max*max;
    }
}
