//K번째 수
package BaekJoon.Sort;

import java.util.Scanner;

public class B11004 {

	public static int[] quickSort(int s,int l, int[] array) {
		int left=s;
		int right=l;
		int pivot=array[(s+l)/2];

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

		if(s<right) quickSort(s,right,array);
		if(l>left) quickSort(left,l,array);

		return array;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int k=sc.nextInt();

        int [] array=new int[num];
        for(int i=0;i<num;i++) {
           array[i]=sc.nextInt();
        }

        int [] answer=quickSort(0,array.length-1,array);

		System.out.println(answer[k-1]);

	}


}
