package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B15903_카드합체놀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();

		long [] a =new long [N];

		for(int i=0;i<N;++i) {
			a[i]=sc.nextLong();
		}


		for(int i=0;i<M;++i) {
			Arrays.sort(a);
			long sum=a[0]+a[1];
			a[0]=sum;
			a[1]=sum;
		}

		long result=0;
		for(int i=0;i<N;++i) {
			result+=a[i];
		}

		System.out.println(result);

	}


}
