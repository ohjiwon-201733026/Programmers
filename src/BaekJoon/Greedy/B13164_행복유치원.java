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
		for(int i=0;i<arr.length;++i){
			arr[i]=sc.nextInt();
		}

		int [] diff=new int [n-1];
		for(int i=0;i<n-1;++i){
			diff[i]=arr[i+1]-arr[i];
		}

		Arrays.sort(diff);
		int sum=0;
		for(int i=0;i<n-k;++i){
			sum+=diff[i];
		}

		System.out.println(sum);

	}

}
