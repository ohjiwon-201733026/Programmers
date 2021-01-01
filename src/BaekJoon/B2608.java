// 로마숫자
package BaekJoon;

import java.util.HashMap;
import java.util.Scanner;

public class B2608 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Integer> hm=new HashMap<>();

		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);


		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		char[] a1=a.toCharArray();
		char[] b1=b.toCharArray();

		int a2=0;

		for(int i=0;i<a1.length;i++) {
			if(hm.get(a1[i])-hm.get(a1[i+1])<0) {
				a2+=hm.get(a1[i])-hm.get(a1[i+1]);
			}
			a2+=hm.get(a1[i]);
		}

		System.out.println(a2);
	}

}
