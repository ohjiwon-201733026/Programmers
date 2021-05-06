//동전0
package BaekJoon.Greedy;

import java.util.Scanner;

public class B11047_동전0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int [] coin=new int[N];
		int cnt=0;

		for(int i=N-1;i>=0;--i) {
			coin[i]=sc.nextInt();
		}

		for(int i=0;i<N;++i) {
			cnt+=K/coin[i];
			K=K%coin[i];
		}

		System.out.println(cnt);


	}

}
