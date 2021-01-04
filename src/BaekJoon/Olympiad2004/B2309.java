// 일곱 난쟁이
package BaekJoon.Olympiad2004;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] nan=new int [9];
		for(int i=0;i<9;i++) {
			nan[i]=sc.nextInt();
		}

		Arrays.sort(nan);
		int sum=0;
		for(int i=0;i<9;i++) {
			sum+=nan[i];
		}

		int tmp=sum-100;
		int x=0;
		int y=0;

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int a=nan[i]+nan[j];
				if(tmp==a&&i!=j) {
					x=i;
					y=j;
					break;
				}
			}
		}

		for(int i=0;i<9;i++) {
			if(i!=x&&i!=y)
			System.out.println(nan[i]);
		}


	}

}
