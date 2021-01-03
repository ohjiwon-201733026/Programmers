/*퀵 정렬*/

package Algorithm;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int [] array=new int[num];
		for(int i=0;i<num;i++) {
			array[i]=sc.nextInt();
		}

		int[] answer=quick_sort(array,0,array.length-1);
		System.out.print("[");
		for(int i=0;i<answer.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("]");

	}

	public static int[] quick_sort(int [] array,int x, int y) {
		int left=x;
		int right=y;
		int pivot=array[(x+y)/2];

		do {
			while(array[left]<pivot) left++;
			while(array[right]>pivot) right--;
			if(left<=right) {
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
				left++;
				right--;
			}
		}while(left<=right);

		if(x<right) quick_sort(array,x,right);
		if(y>left) quick_sort(array,left,y);

		return array;
	}

}
