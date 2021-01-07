// 색종이
package BaekJoon.Olympiad2005;

import java.util.Scanner;

public class B2590 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] arr=new int[7];

		for(int i=1;i<=6;i++) {
			arr[i]=sc.nextInt();
		}

		int five=arr[5]*11; // arr[1]이 들어갈 수 있는 갯수 11개
		int four=arr[4]*5;  // arr[2]가 들어갈 수 있는 갯수 5 개

		int panel=arr[6]+arr[5]+arr[4];

		arr[1]-=five;
		arr[2]-=four;

		if(arr[1]>0&&arr[2]<0) {
			arr[1]+=arr[2]*4;
		}

		panel+=arr[3]/4;

		int three;
		if((three=(arr[3]%4))>0) {
			panel++;
			arr[2]=Math.max(arr[2], 0);
			if(arr[2]>=0) {
				arr[2]-=5-(three-1)*2;
				arr[1]+=arr[2]*4;
				arr[1]-=8-three;
			}

		}




//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}



	}

}
