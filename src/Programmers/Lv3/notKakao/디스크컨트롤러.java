package Programmers.Lv3.notKakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 디스크컨트롤러 {

    @Test
    public void test(){
        Assertions.assertEquals(9,solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public int solution(int [][] jobs) {
        PriorityQueue<int []> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int count=0;
        int n= jobs.length;
        int jobIdx=0;
        int end=0; // 현재 시간
        int answer=0;
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);

        while(count<n){

            while(jobIdx<n && jobs[jobIdx][0]<=end){
                    pq.add(jobs[jobIdx++]);
            }

            if(pq.isEmpty()){
                end=jobs[jobIdx][0];
            }
            else{
                int [] temp=pq.poll();
                answer+= temp[1]+end-temp[0];
                end+=temp[1];
                count++;

            }


        }

        return answer/n;
    }



}
