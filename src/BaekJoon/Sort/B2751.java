package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B2751 {
	public static int [] quickSort(int [] A,int p, int r) { //
		if(p<r){
			int q=partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}

		return A;
	}

	public static int partition(int [] A ,int p, int r) {
		int item=A[r];
		int i=p-1;
		int j=p;
		while(j<r) {
			if(item>A[j]) {
				++i;
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
				++j;
			}else {
				++j;
			}
		}
		int tmp=A[i+1];
		A[i+1]=A[r];
		A[r]=tmp;

		return i+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int [] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}

		Arrays.sort(a);
		for(int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
	}

}
