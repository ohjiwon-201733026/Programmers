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
       int n= jobs.length;
       int end=0;
       int jobsIdx=0;
       int count=0;

       // 도착 시간 오름차순 정렬
       Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);

       // 작업 시간 오름차순 정렬
       PriorityQueue<int []> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);

       while (count<n){

           while (jobsIdx<n && jobs[jobsIdx][0]<=end){
                   pq.add(jobs[jobsIdx++]);
           }
           if(pq.isEmpty()){
               end=jobs[jobsIdx][0];
           }
           else{
               int [] tmp=pq.poll();
               answer+=(end+tmp[1])-tmp[0];
               end+=tmp[1];
               count++;
           }
       }

       return answer/n;
    }
}
