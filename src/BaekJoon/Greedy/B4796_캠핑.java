package BaekJoon.Greedy;

import java.util.Scanner;


public  class B4796_캠핑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		int tc=1;
		while(true) {
			int L=sc.nextInt();
			int P=sc.nextInt();
			int V=sc.nextInt();

			if(L==0) break;

			System.out.println("Case "+tc+": "+((V/P)*L+Math.min(L, V%P)));
			tc++;
		}

	}

}
