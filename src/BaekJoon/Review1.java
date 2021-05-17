package BaekJoon;

import java.util.Scanner;

public class Review1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int length=s.length();
		int [] arr=new int [length];
		for(int i=0;i<length;++i) {
			arr[i]=s.charAt(i)-'0';
		}
		
		int oneCount=0;
		int zeroCount=0;
		int flag=arr[0];
		if(flag==0) zeroCount++;
		else oneCount++;
		
		for(int i=1;i<length;++i) {
			if(arr[i]!=flag) {
				flag=arr[i];
				if(arr[i]==1) oneCount++;
				else zeroCount++;
			}
		}
		
		System.out.println(Math.min(oneCount, zeroCount));
	}

}
