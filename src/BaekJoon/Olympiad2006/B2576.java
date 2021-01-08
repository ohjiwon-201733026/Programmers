// 홀수
package BaekJoon.Olympiad2006;

import java.util.Scanner;
import java.util.Vector;

public class B2576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] arr=new int [7];
		for(int i=0;i<7;i++) {
			arr[i]=sc.nextInt();
		}

		Vector<Integer> v=new Vector<>();
		for(int i=0;i<7;i++) {
			if(arr[i]%2==1) v.add(arr[i]);
		}
		if(v.size()==0) System.out.println(-1);
		else {

		int sum=0;
		for(int i=0;i<v.size();i++) {
			sum+=v.get(i);

		}

		System.out.println(sum);

		int min=Integer.MAX_VALUE;
		for(int i=0;i<v.size();i++) {
			if(v.get(i)<min) min=v.get(i);
		}
		System.out.println(min);
		}
	}


	}


