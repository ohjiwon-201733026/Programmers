package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B13164_행복유치원 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		Integer [] arr=new Integer[N];
		int [] diff=new int [N-1];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		for(int i=0;i<N-1;++i) {
			diff[i]=arr[i+1]-arr[i];
		}

		Arrays.sort(diff);

		int result=0;
		for(int i=0;i<N-K;++i) {
			result+=diff[i];
		}

		System.out.println(result);


	}

}
