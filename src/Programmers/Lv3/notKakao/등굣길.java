package Programmers.Lv3.notKakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 등굣길 {

    @Test
    void test(){
        int m=4;
        int n=3;
        int [][] puddles={{2,2}};
        Assertions.assertEquals(4,solution(m,n,puddles));
    }

    static final int mod=1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int [][] board=new int [n+1][m+1];

        for(int [] arr:puddles){
            board[arr[1]][arr[0]]=-1;
        }
        board[1][1]=1;
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(board[i][j]==-1) continue;
                if(board[i-1][j]>0) board[i][j]+=board[i-1][j]%mod;
                if(board[i][j-1]>0) board[i][j]+=board[i][j-1]%mod;
            }

            }

        return board[n][m]%mod;

    }
}
