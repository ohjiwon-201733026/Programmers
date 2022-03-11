package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {

    @Test
    public void test(){
        Assertions.assertEquals(12, solution(new int []{4,3,3},4));
        Assertions.assertEquals(6, solution(new int []{2,1,2},1));
        Assertions.assertEquals(0, solution(new int []{1,1},3));
    }

    public long solution(int [] works, int n){
        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) -> o2-o1));

        for (int work : works) {
            pq.add(work);
        }

        while (n>0){
            int a=pq.poll();
            if(a==0) return 0;
            a--;
            n--;
            pq.add(a);
        }
        System.out.println(pq);
        long answer=0;
        while (!pq.isEmpty()){
            int a=pq.poll();
            answer+=Math.pow(a,2);
        }

        return answer;
    }
}
