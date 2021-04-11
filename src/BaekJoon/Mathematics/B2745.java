package BaekJoon.Mathematics;

import java.util.Scanner;

public class B2745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String N=sc.next();
		int B=sc.nextInt();
		int ans=0;

		for(int i=0;i<N.length();++i) {
			if('0'<=N.charAt(i) && N.charAt(i)<='9')
				ans+=Math.pow(B, N.length()-i-1)*(N.charAt(i)-'0');
			else {
				ans+=Math.pow(B, N.length()-i-1)*(N.charAt(i)-'A'+10);
			}
		}

		System.out.println(ans);



	}

}
