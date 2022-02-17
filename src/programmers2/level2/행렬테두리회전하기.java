package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class 행렬테두리회전하기 {

    @Test
    public void test(){
        int [] result=solution(6,6,new int [][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});

        int [] answer={8, 10, 25};

        for(int i=0;i<result.length;++i){
            System.out.println(result[i]);
            Assertions.assertEquals(result[i],answer[i]);
        }

    }

    public int [] solution(int rows, int columns, int [][] queries){

        int [][] arr=new int [rows+1][columns+1];
        for(int i=1;i<=rows;++i){
            for(int j=1;j<=columns;++j){
                arr[i][j]=(i-1)*columns+j;
            }
        }
        int [][] tmp=new int [rows+1][columns+1];
        for(int i=1;i<=rows;++i){
            for(int j=1;j<=columns;++j){
                tmp[i][j]=arr[i][j];
            }
        }

        int [] answer=new int [queries.length];
        for (int k=0;k<queries.length;++k) {
            int [] query=queries[k];
            int y1=query[0],x1=query[1],y2=query[2],x2=query[3];
            int min=Integer.MAX_VALUE;
            for(int i=1;i<=rows;++i){
                for(int j=1;j<=columns;++j){
                    arr[i][j]=tmp[i][j];
                }
            }

            for(int i=x1;i<x2;++i) {
                tmp[y1][i+1]=arr[y1][i];
                min=Math.min(min,arr[y1][i]);
            }
            for(int i=y1;i<y2;++i) {
                tmp[i+1][x2]=arr[i][x2];
                min=Math.min(min,arr[i][x2]);
            }
            for(int i=x1+1;i<=x2;++i) {
                tmp[y2][i-1]=arr[y2][i];
                min=Math.min(min,arr[y2][i]);
            }
            for(int i=y1+1;i<=y2;++i) {
                tmp[i-1][x1]=arr[i][x1];
                min=Math.min(min,arr[i][x1]);
            }

            answer[k]=min;

        }

        return answer;
    }
}
