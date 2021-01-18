// 열개씩 끊어 출력하기
package BaekJoon.InOutput;

import java.util.Scanner;

public class B11721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int i=0;
		while(i+10<=s.length()) {
			String tmp=s.substring(i,i+10);
			System.out.println(tmp);
			i+=10;
		}
		System.out.println(s.substring(i));

	}

}
