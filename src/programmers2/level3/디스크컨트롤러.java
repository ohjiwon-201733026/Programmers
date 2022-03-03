package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 디스크컨트롤러 {

    @Test
    public void test(){
        Assertions.assertEquals(9,solution(new int [][]{{0,3},{1,9},{2,6},{1,2}}));
    }
    public class Job implements Comparable<Job>{
        int arrivedTime;
        int workingTime;

        public Job(int arrivedTime, int workingTime) {
            this.arrivedTime = arrivedTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(Job o) {
            if(this.arrivedTime==o.arrivedTime) return this.workingTime-o.workingTime;
            return this.arrivedTime-o.arrivedTime;
        }
    }
    public int solution(int [][] jobs){
        int answer=0;
        int end=0; // 수행 직후 시간
        int jobsIdx=0; // jobs 배열의 인덱스
        int count=0; // 수행된 요청의 갯수

        // 원본 배열 오름차순 정렬( 요청 시간 오름차순 )
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);

        // 처리 시간 오름차순으로 정렬하는 우선순위 큐
        PriorityQueue<int []> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);

        // 요청이 모두 수행될 때까지 반복
        while (count<jobs.length){
            // 하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣음
            while (jobsIdx<jobs.length && jobs[jobsIdx][0]<=end)
                pq.add(jobs[jobsIdx++]);

            // 큐가 비어있다면 작업 완료 이후에 다시 요청이 들어온다는 의미
            // end를 요청의 가장 처음으로 맞춰줌
            if(pq.isEmpty()){
                end=jobs[jobsIdx][0];
            }
            else {
                int [] tmp=pq.poll();
                answer+=tmp[1]+end-tmp[0];
                end+=tmp[1];
                count++;
            }
        }

        return answer/jobs.length;
    }
}
