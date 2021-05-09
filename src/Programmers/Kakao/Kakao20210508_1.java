package Programmers.Kakao;

import java.util.Scanner;

public class Kakao20210508_1 {

	public static String [] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();

		solution(s);

	}

	private static boolean isNum(char c) {
		if('0'<= c && c<='9') return true;
		else return false;
	}

	private static StringBuilder sb=new StringBuilder();

	private static void solution(String s) {
		// TODO Auto-generated method stub
		StringBuilder tmp=new StringBuilder();
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if(isNum(c)) {
				System.out.print(c);
			}
			else {
				tmp.append(c);
				for(int j=0;j<10;++j) {
					if(tmp.toString().equals(num[j])) {
						System.out.print(j);
						tmp=new StringBuilder();
					}
				}
			}


		}
	}

}
