package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 공이동시뮬레이션 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(2,2,0,0,new int [][]{{2,1},{0,1},{1,1},{0,1},{2,1}}));
        Assertions.assertEquals(2,solution(2,5,0,1,new int [][]{{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}}));
    }
    public long solution(int n, int m, int x, int y, int [][] queries){
        long answer=0;

        // 기준점
        int newRow=x;
        int newCol=y;

        // 쿼리를 거꾸로, 기준점을 구한다
        for(int i= queries.length-1;i>=0;--i){
            int [] query=queries[i];
            int dx=query[1];

            // 이동
            if(query[0]==0){ // 왼->오
                newCol+=dx;
                newCol=Math.min(n-1,newCol);
            }
            else if(query[0]==1){ // 오->왼
                newCol-=dx;
                newCol=Math.max(0,newCol);
            }
            else if(query[0]==2){ // 위 -> 아래
                newRow+=dx;
                newRow=Math.min(n-1,newRow);
            }else{
                newRow-=dx;
                newRow=Math.max(0,newRow);
            }
        }
        
        // 기준점을 출발해서 제대로된 쿼리를 다시 실행
        int left=newCol;
        int right=newCol;
        int up=newRow;
        int down=newRow;
        for(int [] query: queries){ // 쿼리 실행
            int dx=query[1]; // 몇 칸

            // 이동
            if(query[0]==0){ // 왼쪽
                newCol-=dx;
                newCol=Math.max(0,newCol);
                if(newCol==0){
                    left=0;
                }
            }else if(query[0]==1){
                newCol+=dx;
                newCol=Math.min(m-1,newCol);
                if(newCol==m-1){
                    right=m-1;
                }
            }else if(query[0]==2){
                newRow-=dx;
                newRow=Math.max(0,newRow);
                if(newRow==0){
                    up=0;
                }
            }else{
                newRow+=dx;
                newRow=Math.min(n-1,newRow);
                if(newRow==n-1){
                    down=n-1;
                }
            }
        }

        if(newRow==x && newCol==y){
            answer=(long)(right-left+1)*(down-up+1);
        }
        else{
            answer=0;
        }

        return answer;
    }
}
