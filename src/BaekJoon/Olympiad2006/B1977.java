// 완전제곱수
package BaekJoon.Olympiad2006;

import java.util.Scanner;
import java.util.Vector;

public class B1977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int start=sc.nextInt();
		int end=sc.nextInt();
		Vector<Integer> v=new Vector<>();
		int tmp=(int) Math.sqrt(start);

		for(int i=tmp;i<=Math.sqrt(end);i++) {
			if(i*i>=start && i*i<=end)
				v.add(i*i);
		}

		if(v.size()==0) {
			System.out.println("-1");
			System.exit(0);
		}
		int sum=0;
		for(int i=0;i<v.size();i++) {
			sum+=v.get(i);
		}
		System.out.println(sum);
		System.out.println(v.get(0));


	}

}
