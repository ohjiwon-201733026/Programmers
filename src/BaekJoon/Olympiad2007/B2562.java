// 최댓값
package BaekJoon.Olympiad2007;

import java.util.Scanner;

public class B2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] arr=new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}

		int maxIdx = 0;
		int maxVal=0;
		for(int i=0;i<arr.length;i++) {
			if(maxVal<arr[i]) {
				maxVal=arr[i];
				maxIdx=i;
			}
		}

		System.out.println(maxVal);
		System.out.println(maxIdx+1);
	}

}
