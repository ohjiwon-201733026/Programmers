package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class 더맵게 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(new int []{1, 2, 3, 9, 10, 12},7));
    }

    public int solution(int [] scoville, int K){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        int cnt=0;
        while(true) {

            int n=pq.peek();

            if(n>=K) break;
            if(pq.size()<2) break;

            int a = pq.poll();
            int b = pq.poll();

            int tmp = a + 2 * b;
            pq.add(tmp);
            cnt++;
        }

        if(pq.peek()<K) return -1;

        return cnt;
    }
}
