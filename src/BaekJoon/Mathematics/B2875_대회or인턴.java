package BaekJoon.Mathematics;

import java.util.Scanner;

public class B2875_대회or인턴{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int W=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		int cnt=0;

		while(K!=0) {
			if(W>=M*2) W--;
			else M--;
			K--;
		}

		cnt=(W>=M*2?M:W/2);

		System.out.println(cnt);
	}

}
