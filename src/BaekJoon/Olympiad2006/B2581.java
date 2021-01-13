//소수
package BaekJoon.Olympiad2006;

import java.util.Scanner;
import java.util.Vector;

public class B2581 {

	public static boolean prime(int n) {

		if(n<2) return false;
		if(n==2) return true;

		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int start=in.nextInt();
		int end=in.nextInt();
		Vector<Integer> v=new Vector<>();

		for(int i=start;i<=end;i++) {
			if(prime(i)) v.add(i);
		}

		if(v.size()==0) {
			System.out.println("-1");
			System.exit(0);
		}

		int sum=0;
		for(int i=0;i<v.size();i++) {
			sum+=v.get(i);
		}
		System.out.println(sum); // 소수 합
		System.out.println(v.get(0)); // 소수 최소값

	}

}
