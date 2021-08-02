package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length=100;
        int weight=100;
        int [] truck_weights={10};
        int answer=solution(bridge_length,weight,truck_weights);
        System.out.println(answer);
    }

    public static int solution(int bridge_length, int weight, int [] truck_weights){

        Queue<Integer> bridge=new LinkedList<>();
        int w=0; // 다리 위 무게
        int answer=0;
        Queue<Integer> before_bridge=new LinkedList<>();

        for(int n:truck_weights) before_bridge.offer(n);
        
        while(true){
            if(before_bridge.size()==0) break;
            if(bridge.size()==bridge_length) w-=bridge.poll();
            else{
                if(w+before_bridge.peek()<=weight){
                    w+=before_bridge.peek();
                    bridge.offer(before_bridge.poll());
                    answer++;
                }
                else{
                    bridge.add(0);
                    answer++;
                }
            }
        }
        answer+=bridge_length;


       
        return answer;
    }
}
