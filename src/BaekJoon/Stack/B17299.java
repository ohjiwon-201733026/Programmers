package BaekJoon.Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B17299 {
	public class Number{
		int key;
		int count;

		public Number(int key) {
			this.key=key;
			this.count=0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer [] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}

		HashMap<Integer, Integer> hm=new HashMap<>();
		for(int num:arr) {
			hm.put(num, hm.getOrDefault(num,0)+1);
		}

		Stack<Integer> stack=new Stack<>();
		stack.push(arr[0]);
		for(int i=1;i<n;i++) {
			if(hm.getValue(arr[1]))
		}

	}

}
