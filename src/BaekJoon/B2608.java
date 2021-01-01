// 로마숫자
package BaekJoon;

import java.util.HashMap;
import java.util.Scanner;

public class B2608 {
	static HashMap<Character, Integer> hm;

	public static int charToInteger(char[] b1) {
		int sum = 0;

		for (int i = 0; i < b1.length; i++) {

			if (i == b1.length - 1) {
				sum += hm.get(b1[i]);
				break;
			}

			if (hm.get(b1[i]) >= hm.get(b1[i + 1])) {
				sum += hm.get(b1[i]);
			}

			else if (hm.get(b1[i]) < hm.get(b1[i + 1])) {
				sum += (hm.get(b1[i + 1]) - hm.get(b1[i]));
				i = i + 1;
			}

		}

		return sum;
	}

	public static String integerToString(String s,int sum) {
		while (sum >= 1000) {
			s += "M";
			sum -= 1000;
		}
		if (sum >= 900) {
			s += "CM";
			sum -= 900;
		}
		if (sum >= 500) {
			s += "D";
			sum -= 500;
		}
		if (sum >= 400) {
			s += "CD";
			sum -= 400;
		}
		while (sum >= 100) {
			s += "C";
			sum -= 100;
		}
		if (sum >= 90) {
			s += "XC";
			sum -= 90;
		}
		if (sum >= 50) {
			s += "L";
			sum -= 50;
		}
		if (sum >= 40) {
			s += "XL";
			sum -= 40;
		}
		while (sum >= 10) {
			s += "X";
			sum -= 10;
		}
		if (sum >= 9) {
			s += "IX";
			sum -= 9;
		}
		if (sum >= 5) {
			s += "V";
			sum -= 5;
		}
		if (sum >= 4) {
			s += "IV";
			sum -= 4;
		}
		while (sum >= 1) {
			s += "I";
			sum -= 1;
		}
		return s;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hm = new HashMap<>();

		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);

		Scanner sc = new Scanner(System.in);
		String a1 = sc.next();
		String a2 = sc.next();

		char[] b1 = a1.toCharArray();
		char[] b2 = a2.toCharArray();

		int sum1 = charToInteger(b1);
		int sum2 = charToInteger(b2);

		int sum = sum1 + sum2;
		System.out.println(sum);
		System.out.println(integerToString("",sum));


	}

}
