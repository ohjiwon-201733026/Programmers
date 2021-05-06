package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B2217_로프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] a=new int [N];
		int [] b=new int [N];

		for(int i=0;i<N;++i) a[i]=sc.nextInt();

		Arrays.sort(a);

		for(int i=0;i<N;++i) b[i]=a[i]*(N-i);

		int max=0;
		for(int i=0;i<N;++i) {
			if(max<b[i]) max=b[i];
		}

		System.out.println(max);
	}

}
