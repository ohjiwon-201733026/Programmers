package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class NQueen {
    
    @Test
    public void test(){
        Assertions.assertEquals(2,solution(4));
    }
    static int [] col; // 한 행에 퀸 위치
    static int answer=0;
    public int solution(int n) {
        for(int i=0;i<n;++i){
            col=new int [n];
            col[0]=i;
            backtracking(n,1);
        }
        return answer;

    }

    private void backtracking(int max, int row) {
        if(row==max){
            answer++;
            return;
        }

        for(int i=0;i<max;++i){
            col[row]=i;
            if (isPossible(row)) {
                backtracking(max,row+1);
            }
            else{
                col[row]=0;
            }
        }
//        col[row]=0;
    }

    private boolean isPossible(int row) {
        for(int i=0;i<row;++i){ // 0~row-1까지 체크
            if(col[i]==col[row]) return false; // 같은 열
            if(Math.abs(row-i)==Math.abs(col[row]-col[i])) return false; // 대각선
        }
        return true;
    }

}
