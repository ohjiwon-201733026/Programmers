// 소수 에라토스테네스의 체
package BaekJoon.Olympiad2006;

import java.util.Scanner;
import java.util.Vector;

public class B2581a {

	public static boolean [] prime;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int start=in.nextInt();
		int end=in.nextInt();
		Vector<Integer> v=new Vector<>();
		make_prime(end);

		for(int i=start;i<prime.length;i++) {
			if(prime[i]==false) v.add(i);
		}

		int sum=0;
		for(int i=0;i<v.size();i++) {
              sum+=v.get(i);
		}

		System.out.println(sum); // 소수 합
		System.out.println(v.get(0)); // 소수 최소값


	}

	public static void make_prime(int n) {
		prime=new boolean[n+1]; // 0~n

		// 소수가 아닌 index는 true
		// 소수인 index는 false

		if(n<2) return;

		prime[0]=prime[1]=true;

		for(int i=2;i<Math.sqrt(n);i++) {
			if(prime[i]) continue;
			for(int j=i*i;j<prime.length;j+=i)
				prime[j]=true;
		}
	}

}
