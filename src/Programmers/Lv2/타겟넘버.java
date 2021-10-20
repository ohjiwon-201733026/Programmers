package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 타겟넘버 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(new int []{1, 1, 1, 1, 1},3));
    }

    static int count=0;
    static int N;
    static int [] num;
    public int solution(int [] numbers, int target){
        N=numbers.length;
        num=numbers;
        dfs(0,0,target);

        return count;
    }

    private void dfs(int i, int sum, int target){

        if(i==N){
            if(sum==target) count++;
            return;
        }

        dfs(i+1,sum+num[i],target);
        dfs(i+1,sum-num[i],target);
    }
}
