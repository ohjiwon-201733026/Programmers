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

    static int [][] map;
    static final int mod=1000000007;
    public int solution(int m, int n, int[][] puddles) {
        map=new int [n][m];

        for(int [] arr:puddles){
            int x=arr[0]-1,y=arr[1]-1;
            map[y][x]=-1;
        }

        for(int i=0;i<n;++i) {
            if(map[i][0]!=-1) map[i][0]=1;
            else break;
        }

        for(int i=0;i<m;++i) {
            if(map[0][i]!=-1) map[0][i]=1;
            else break;
        }

        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                if(map[i][j]!=-1){
                    if(map[i-1][j]!=-1) map[i][j]+=map[i-1][j]%mod;
                    if(map[i][j-1]!=-1) map[i][j]+=map[i][j-1]%mod;
                }

            }
        }


        return map[n-1][m-1];

    }
}
