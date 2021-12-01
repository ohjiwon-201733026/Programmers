package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {

    @Test
    public void test(){
        Assertions.assertEquals(12,solution(new int []{4,3,3},4));
        Assertions.assertEquals(6,solution(new int []{2,1,2},1));
        Assertions.assertEquals(0,solution(new int []{1,1},3));
    }

    public long solution(int [] works,int n){
      long answer=0;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.add(work);
        }

        while(true){
            if(n==0) break;
            if(pq.isEmpty()) return 0;

            int cur=pq.poll();
            cur-=1;
            n--;
            if(cur!=0) pq.add(cur);

        }

        while(!pq.isEmpty()){
            int a=pq.poll();
            answer+=a*a;
        }

      return answer;
    }
}
