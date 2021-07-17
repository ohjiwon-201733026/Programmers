package Programmers.Lv2;

import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        int [] scoville={1,2,3,9,10,12};
        int K= 7;
        int answer=solution(scoville,K);
        System.out.println(answer);

    }

    private static int solution(int[] scoville, int K) {
        int answer=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int n:scoville) pq.add(n);

        while(true){

            int n=pq.peek();


            if(n>=K) break;
            else if(pq.size()<2) break;
            else{
                int a=pq.poll();
                int b=pq.poll();
                pq.add(a+2*b);

                answer++;
            }


        }

        if(pq.peek()<K) return -1;
        return answer;
    }
}
