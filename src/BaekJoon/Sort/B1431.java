package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1431 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String [] arr=new String[n];
		for(int i=0;i<n;++i) {
			arr[i]=sc.next();
		}

		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()<o2.length()) return Integer.compare(o1.length(), o2.length());

				else if(o1.length()==o2.length()){
					int aSum=getSum(o1);
					int bSum=getSum(o2);
					if(aSum==bSum) return o1.compareTo(o2);
					else {
						return Integer.compare(aSum, bSum);
					}
				}
				return 0;
			}

			private int getSum(String o1) {
				// TODO Auto-generated method stub
				int sum=0;
				for(int i=0;i<o1.length();++i) {
					if(o1.charAt(i)>='0'&&o1.charAt(i)<='9')
						sum+=o1.charAt(i)-'0';
				}

				return sum;
			}

		});

		for(int i=0;i<arr.length;++i) {
			System.out.println(arr[i]);
		}

	}

}
