package codingTest.StackQeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Truck{
	int weight;
	int move; // 트럭의 다리 위에서 위치

	public Truck(int weight) {
		this.weight=weight;
		this.move=1;
	}

	public void moving() {
		move++;
	}
}

public class StackQueue3A {



	public static int solution(int bridgeLength,int weight,int [] truckWeights) {
		Queue<Truck> waitQ=new LinkedList<>();
		Queue<Truck> moveQ=new LinkedList<>();

		for(int t:truckWeights) {
			waitQ.offer(new Truck(t));
		}

		int answer=0;
		int curWeight=0;

		while(!waitQ.isEmpty()||!moveQ.isEmpty()) {
			answer++;

			if(moveQ.isEmpty()) { // 다리 위 트럭 없을 경우
				Truck t=waitQ.poll();
				curWeight+=t.weight;
				moveQ.offer(t);
				continue;
			}

			for(Truck t: moveQ) { // 다리위 트럭 움직임
				t.moving();
			}

			if(moveQ.peek().move>bridgeLength) {
				// 다리 위 젤 앞에 있는 트럭의 움직인 거리가 다리 길이보다 길 경우
				Truck t=moveQ.poll(); // 큐에서 빼고 도착한 트럭으로
				curWeight-=t.weight;
			}

			if(!waitQ.isEmpty()&&curWeight+waitQ.peek().weight<=weight) {
				// 기다리는 트럭이 남아있고 현재 다리 위 트럭의 무게+ 대기 큐 트럭 무게의 합이 다리가 견디는 무게보다 작은 경우
				Truck t=waitQ.poll(); // 대기 큐에 있는 트럭 다리위로 올리기
				curWeight+=t.weight;
				moveQ.offer(t);
			}
		}

		return answer;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int bridge_length=sc.nextInt();
		int weight=sc.nextInt();
		int num=sc.nextInt();
		int [] truck_weights=new int[num];
		for(int i=0;i<num;i++) {
			truck_weights[i]=sc.nextInt();
		}

		int answer=solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}

}
