// 최소, 최대
package BaekJoon.InOutput;

import java.util.Arrays;
import java.util.Scanner;

public class B10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] array=new int [n];

		for(int i=0;i<array.length;++i) array[i]=sc.nextInt();
		Arrays.sort(array);

		System.out.println(array[0]+" "+ array[n-1]);
	}

}
