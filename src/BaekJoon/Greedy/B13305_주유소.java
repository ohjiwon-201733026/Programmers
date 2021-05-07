package BaekJoon.Greedy;

import java.util.Scanner;

public class B13305_주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long [] arr=new long[N-1];
		long [] oil=new long[N-1];
		for(int i=0;i<arr.length;++i) {
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<oil.length;++i) {
			oil[i]=sc.nextInt();
		}

		long min=Integer.MAX_VALUE;
		long res=0;
		for(int i=0;i<N-1;++i) {
			if(min>oil[i]) min=oil[i];
			res+=min*arr[i];
		}
		System.out.println(res);

	}

}
