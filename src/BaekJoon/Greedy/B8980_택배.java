package BaekJoon.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B8980_택배 {
	public static class Box implements Comparable<Box>{
		int start;
		int end;
		int weight;

		Box(int start, int end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}

		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			if(this.start==o.start) {
				return this.end-o.end;
			}
			return this.start-o.start;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); // 마을 수
		int C=sc.nextInt(); // 트럭 용량
		int M=sc.nextInt(); // 박스 수
		Box [] arr=new Box[M];
		ArrayList<Box> truck=new ArrayList<>();
		int cur=0;// 현재 트럭에 실은 중량
		int sum=0; // 총 옮긴 박스 중량

		for(int i=0;i<M;++i) {
			arr[i]=new Box(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(arr);

		for(int i=1;i<=N;++i) { // 마을 방문

			// i마을 배송지에 배송하기
			for(int j=0;j<truck.size();++j) {
				if(truck.get(j).end==i) {
					cur-=truck.get(j).weight; // 트럭에서 내리기
					truck.remove(j);
				}
			}

			// 트럭에 실기
			for(int k=0;k<arr.length;++k) { // 박스 순환
				if(cur>C) break;
				if(arr[k].start==i) { // 출발지이면
					if(arr[k].weight+cur<C) { // 실어서 트럭 용량
						cur+=arr[k].weight;
						truck.add(new Box(arr[k].start,arr[k].end,arr[k].weight));
						sum+=arr[k].weight;
					}
					else {
						int w=C-cur;
						cur+=w;
						truck.add(new Box(arr[k].start,arr[k].end,w));
						sum+=w;

					}
				}
			}


		}

		System.out.println(sum);

	}

}
