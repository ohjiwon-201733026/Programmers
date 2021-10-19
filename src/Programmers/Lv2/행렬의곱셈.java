package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 행렬의곱셈 {

    @Test
    public void test(){
        int [][] answer=solution(new int [][]{{1, 4}, {3, 2}, {4, 1}},new int [][]{{3, 3}, {3, 3}});
        for(int i=0;i< answer.length;++i){
            for(int j=0;j<answer[0].length;++j){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }

    public int [][] solution(int [][] arr1, int [][] arr2){
        int N=arr1.length;
        int M=arr2[0].length;
        int [][] inter=new int[N][M];


        for(int i=0;i< arr1.length;++i){
            for(int j=0;j<arr2[0].length;++j){
                for(int k=0;k<arr1[0].length;++k){
                    inter[i][j]+=(arr1[i][k]*arr2[k][j]);
                }
            }
        }
        return inter;
    }
}
