package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 타겟넘버 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(new int []{1,1,1,1,1},3));
        Assertions.assertEquals(2,solution(new int []{4,1,2,1},4));
    }

    public int solution(int [] numbers, int target){
        answer=0;
        dfs(numbers,target, 0,0,"");

        return answer;
    }
    public static int answer;
    public void dfs(int [] numbers, int target, int sum,int i,String s){

        if( i==numbers.length){
            if(sum==target ) answer++;
            return;
        }

        dfs(numbers,target,sum+numbers[i],i+1,s+"+"+numbers[i]);
        dfs(numbers,target,sum-numbers[i],i+1,s+"-"+numbers[i]);
    }
}
