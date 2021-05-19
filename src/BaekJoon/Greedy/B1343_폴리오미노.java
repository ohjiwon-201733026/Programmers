package BaekJoon.Greedy;

import java.util.Scanner;

public class B1343_폴리오미노 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();

		s=s.replaceAll("XXXX", "AAAA");
		s=s.replaceAll("XX", "BB");

		if(s.contains("X")) {
			System.out.println(-1);
		}else {
			System.out.println(s);
		}


	}

}
