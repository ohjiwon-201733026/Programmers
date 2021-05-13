package BaekJoon.Greedy;

import java.util.Scanner;

public class D2_1이될때까지{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int cnt=0;
		if(K>=2) {
		while(true) {
			if(N==1) break;
			if(N%K==0) {
				N=N/K;
				cnt++;
			}
			else {
				N--;
				cnt++;
			}
		}
		}
		else {
			while(N!=1) {
				N--;
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
