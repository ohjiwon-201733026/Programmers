package BaekJoon.Greedy;

import java.util.Scanner;

public class B1138_한줄로서기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr=new int [N];
		int leftCount;

		for(int val=0;val<N;val++) {
			leftCount=sc.nextInt();

			for(int i=0;i<N;++i) {
				if(leftCount==0 & arr[i]==0) {
					arr[i]=val+1;
					break;
				}else if(arr[i]==0) leftCount--;
			}
		}

		for(int i=0;i<N;++i) {
			System.out.print(arr[i]+" ");
		}

	}

}
