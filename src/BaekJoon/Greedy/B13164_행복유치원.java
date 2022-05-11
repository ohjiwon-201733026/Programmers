package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B13164_행복유치원 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [] arr=new int [n];
		PriorityQueue<Integer> pq=new PriorityQueue<>();

		for(int i=0;i<n;++i){
			arr[i]=sc.nextInt();
		}

		for(int i=0;i<n-1;++i){
			pq.add(arr[i+1]-arr[i]);
		}
		int sum=0;
		for(int i=0;i<n-k;++i){
			sum+=pq.poll();
		}

		System.out.println(sum);

	}

}
