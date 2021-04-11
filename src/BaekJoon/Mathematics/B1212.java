package BaekJoon.Mathematics;

import java.util.Scanner;

public class B1212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String [] arr= {"000","001","010","011","100","101","110","111"};

		String s=sc.next();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			int k=c-'0';
			sb.append(arr[k]);
		}

		char[] ans=sb.toString().toCharArray();
		int t=0;
		if(s.equals("0")) System.out.println("0");
		else {
		while(ans[t]=='0'&&t<ans.length) {
			++t;
		}
		StringBuilder sb1=new StringBuilder();
		for(int j=t;j<ans.length;++j)  sb1.append(ans[j]);

		System.out.println(sb1);
		}
	}

}
