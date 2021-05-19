package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11508_2플러스1세일 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Integer [] arr =new Integer [N];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}

		});

		int result=0;

		for(int i=0;i<N;++i) {
			result+=arr[i];
		}

		for(int i=0;i<N;++i) {
			if((i+1)%3==0) {
				result-=arr[i];
			}
		}

		System.out.println(result);



	}

}
