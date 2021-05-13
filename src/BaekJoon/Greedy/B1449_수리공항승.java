package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B1449_수리공항승 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int L=sc.nextInt();
		int [] arr=new int [N];
		int tape=0;

		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);
		int tapeRange=(int)(arr[0]-0.5+L);
		tape++;

		for(int i=1;i<N;++i) {
			if(tapeRange<(int)(arr[i]+0.5)) {
				tapeRange=(int)(arr[i]-0.5+L);
				tape++;
			}
		}

		System.out.println(tape);
	}

}
