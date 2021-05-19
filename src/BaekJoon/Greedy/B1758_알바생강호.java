package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1758_알바생강호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Integer [] arr=new Integer [N];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr,Comparator.reverseOrder());

		long result=0;
		for(int i=0;i<N;++i) {
			if(arr[i]-i>=0) result+=(arr[i]-i);
			else result+=0;
		}
		System.out.println(result);

	}

}
