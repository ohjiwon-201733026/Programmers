package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class gumyeongboat {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(new Integer []{70, 50, 80, 50},100));
        Assertions.assertEquals(3,solution(new Integer []{70, 80, 50},100));
    }

    public int solution(Integer [] people,int limit){
        int answer=0;
        Integer [] orderPeople=new Integer[people.length];
        for(int i=0;i<people.length;++i)
            orderPeople[i]=people[i];

        Arrays.sort(orderPeople, Collections.reverseOrder());

        int left=0,right=orderPeople.length-1;
        while (left<right){
            int sum=orderPeople[left];
            if(sum+orderPeople[right]<=limit){
                right--;
            }
            left++;
            answer++;
        }

        if(left==right) answer++;

        return answer;
    }


}
