package BaekJoon.Greedy;

import java.util.Scanner;

public class B2847_게임을만든동준이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr =new int [N];

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		int cnt=0;
		int diff=0;
		if(N==1) System.out.println(0);
		else {
		for(int i=N-2;i>=0;--i) {
			if(arr[i]>=arr[i+1]) {
				diff=arr[i]-arr[i+1]+1;
				cnt+=diff;
				arr[i]-=diff;
			}
		}

		System.out.println(cnt);
		}

	}

}
