package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B10867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int tmp=sc.nextInt();
			if(!list.contains(tmp))
				list.add(tmp);
		}
		Collections.sort(list);
		for(int a: list) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
