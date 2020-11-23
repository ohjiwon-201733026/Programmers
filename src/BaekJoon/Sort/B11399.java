//ATM
package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int [] array=new int[num];
		for(int i=0;i<num;i++) {
			array[i]=sc.nextInt();
		}

		int n=solution(array);
		System.out.println(n);

	}

	public static int solution(int[] array) {
		int answer=0;
		Arrays.sort(array);
		int [] temp=new int[array.length];

		temp[0]=array[0];
		for(int i=1;i<array.length;i++) {
			temp[i]=temp[i-1]+array[i];
		}

		for(int i=0;i<array.length;i++) {
			answer+=temp[i];
		}



		return answer;
	}

}
