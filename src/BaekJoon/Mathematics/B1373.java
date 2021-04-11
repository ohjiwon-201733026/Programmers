package BaekJoon.Mathematics;

import java.util.Scanner;

public class B1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String N=sc.next();
		StringBuilder sb=new StringBuilder();

		if(N.length()%3==1) sb.append(N.charAt(0));
		if(N.length()%3==2) sb.append((N.charAt(0)-'0')*2+(N.charAt(1)-'0'));

		for(int i=N.length()%3;i<N.length();i+=3) {
			sb.append((N.charAt(i)-'0')*4+(N.charAt(i+1)-'0')*2+(N.charAt(i+2)-'0'));
		}
		System.out.println(sb);
	}

}
