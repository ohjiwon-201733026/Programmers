package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2751 {
	public static int [] a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			a.add(sc.nextInt());
		}

		Collections.sort(a);

		for(int value:a) {
			sb.append(value).append('\n');
		}

		System.out.println(sb);
	}



}
