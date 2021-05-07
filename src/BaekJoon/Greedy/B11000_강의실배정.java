package BaekJoon.Greedy;

import java.util.Scanner;

public class B11000_강의실배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long [] S=new long[N];
		long [] T=new long[N];
		int [] a=new int [N];

		for(int i=0;i<N;++i) {
			S[i]=sc.nextLong();
			T[i]=sc.nextLong();
		}
		int cnt=1;
		a[0]=cnt;
		long s=T[0];
		for(int i=0;i<N;++i) {
			if(a[i]==0) check(i,cnt);
		}


	}


}
