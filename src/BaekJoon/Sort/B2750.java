/*수 정렬하기*/
package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=sc.nextInt();
		}

		Arrays.sort(num);
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}


	}

}
