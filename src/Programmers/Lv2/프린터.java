package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {

    @Test
    public void test(){
        Assertions.assertEquals(1,solution(new int []{2,1,3,2},2));
//        Assertions.assertEquals(5,solution(new int []{1,1,9,1,1,1},0));
    }

    public int solution(int [] priorities, int location){
        int answer=1;

        PriorityQueue p=new PriorityQueue(Collections.reverseOrder());
        for (int priority : priorities) {
            p.add(priority);
        }
        System.out.println(p);

        while(!p.isEmpty()){
            for(int i=0;i< priorities.length;++i){
                if(priorities[i]==(int)p.peek()){
                    if(i==location) return answer;
                    p.poll();
                    answer++;
                }
            }
        }

        return answer;




    }
}
