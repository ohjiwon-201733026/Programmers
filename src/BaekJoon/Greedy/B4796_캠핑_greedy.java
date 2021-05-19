package BaekJoon.Greedy;

import java.util.Scanner;

public class B4796_캠핑_greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		int tc=1;
		while(true) {
			int L=sc.nextInt();
			int P=sc.nextInt();
			int V=sc.nextInt();
			int answer=0;

			if(L==0) break;

			while(V>0) {
				int token=0;
				if(V>=P) {
					token=P;
					V-=P;
				}
				else {
					token=V;
					V=0;
				}

				if(token>=L) answer+=L;
				else answer+=token;

			}

			System.out.println("Case "+tc+": "+answer);
			tc++;
		}

	}

}
