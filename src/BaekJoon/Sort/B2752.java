package BaekJoon.Sort;

import java.util.Scanner;

public class B2752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] arr=new int[3];
		for(int i=0;i<3;i++) arr[i]=sc.nextInt();
		int maxIdx=0;
		for(int last=2;last>=0;--last) {
			int max=Integer.MIN_VALUE;
			for(int i=0;i<=last;++i) {
				if(max<arr[i]) {
					max=arr[i];
					maxIdx=i;
				}
			}

			int temp=arr[maxIdx];
			arr[maxIdx]=arr[last];
			arr[last]=temp;

		}

		for(int i=0;i<3;i++) {
			System.out.println(arr[i]+" ");
		}
	}

}
