package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Review1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr =new int [N];
		int [] b=new int [N];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);

		for(int i=0;i<N;++i) {
			b[i]=arr[i]*(N-i);
		}
		int max=0;
		for(int i=0;i<N;++i) {
			if(max<b[i]) max=b[i];
		}

		System.out.println(max);
	}

}
