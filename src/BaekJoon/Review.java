package BaekJoon;

import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=1;
		while(true) {
			int L=sc.nextInt();
			int P=sc.nextInt();
			int V=sc.nextInt();


			if(L==0) break;
			int cnt=0;

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
				if(token>=L) cnt+=L;
				else cnt+=token;
			}
			System.out.println("Case "+tc+": "+cnt);
			tc++;

		}

	}

}
