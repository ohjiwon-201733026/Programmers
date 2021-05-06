package BaekJoon.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class B1541_잃어버린괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int result=0;
		String [] a=s.split("-");
		ArrayList<Integer> list=new ArrayList<>();
		for(int j=0;j<a.length;++j) {
			int calcNum=calc(a[j]);

			if(j==0) result+=calcNum;
			else result-=calcNum;

		}

		System.out.println(result);

	}

	private static int calc(String str) {
		// TODO Auto-generated method stub
		String [] a=str.split("\\+");
		int result=0;

		for(String item:a) {
			result+=Integer.parseInt(item);
			}

		return result;
	}

}
