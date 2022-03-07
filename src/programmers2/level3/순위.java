package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 순위 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(5,new int [][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int [][] results){
        int answer=0;
        boolean [][] game=new boolean[n][n];

        for(int i=0;i<results.length;++i){
            game[results[i][0]-1][results[i][1]-1]=true;
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                for(int k=0;k<n;++k){
                    if(game[j][i] && game[i][k]) game[j][k]=true;
                }
            }
        }

        for(int i=0;i<n;++i){
            int result=0;
            for(int j=0;j<n;++j){
                if(game[i][j] || game[j][i]) result++;
            }
            if(result==n-1) answer++;
        }
        return answer;
    }
}
