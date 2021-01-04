//대표값
package BaekJoon.Olympiad2005;

import java.util.Arrays;
import java.util.Scanner;

public class B2587 {

	public static int average(int [] array) {
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		return sum/array.length;
	}

	public static int middleValue(int [] array) {
		Arrays.sort(array);
		return array[2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] array=new int [5];
		for(int i=0;i<5;i++) {
			array[i]=sc.nextInt();
		}
		System.out.println(average(array));
		System.out.println(middleValue(array));



	}

}
