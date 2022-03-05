package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 디스크컨트롤러 {

    @Test
    public void test(){
        Assertions.assertEquals(9,solution(new int [][]{{0,3},{1,9},{2,6}}));
    }

    public int solution(int [][] jobs){
       int answer=0;
       int cnt=0;
       int jobsIdx=0;
       int end=0;

       Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);

       PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);

       while (cnt!=jobs.length){

           while (jobsIdx<jobs.length && jobs[jobsIdx][0]<=end){
               pq.add(jobs[jobsIdx++]);
           }

           if(pq.isEmpty()) end=jobs[jobsIdx][0];
           else{
               int [] tmp=pq.poll();
               end+=tmp[1];
               answer+=end-tmp[0];
               cnt++;
           }
       }

       return answer/jobs.length;

    }
}
