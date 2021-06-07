package study.week4;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] truck_weights= {10};
		int res=solution(100,100,truck_weights);
		System.out.println(res);
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>(); // truck_weights
		Queue<Integer> bridge=new LinkedList<>();
		int w=0; // 다리 위 무게
		int sec=0;

		for(int i=0;i<truck_weights.length;++i) {
			q.add(truck_weights[i]);
		}
		int idx=0;
		while(true) {
//			if(bridge.isEmpty()) {
//				int truck=truck_weights[idx];
//				bridge.offer(truck);
//				w+=truck;
//				sec++;
//			}
			if(idx==truck_weights.length) break;

			if(bridge.size()==bridge_length) {
				int truck=bridge.poll();
				w-=truck;
			}
			else {
				if(w+truck_weights[idx]>weight) {
					bridge.add(0);
					sec++;
				}
				else {
					int truck=truck_weights[idx];
					bridge.add(truck);
					w+=truck;
					sec++;
					idx++;
				}
			}


		}

		if(bridge.size()!=0) sec+=bridge.size();

		return sec;

	}


}
