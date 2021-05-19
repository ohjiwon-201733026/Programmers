package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B20115_에너지드링크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Integer [] arr=new Integer[N];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr,Comparator.reverseOrder());

		double result=arr[0];
		double sum=0;
		for(int i=1;i<N;++i) {
			sum+=arr[i];
		}
		result+=(sum/2);

		System.out.println(result);

	}

}
