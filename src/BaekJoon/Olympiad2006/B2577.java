// 숫자의 개수
package BaekJoon.Olympiad2006;

import java.util.Scanner;

public class B2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int x=A*B*C;

		int [] ans=solution(x);

		for(int a:ans) System.out.println(a);

	}

	private static int[] solution(int x) {
		// TODO Auto-generated method stub

		String s=Integer.toString(x);
		int [] answer=new int [10];
		for(int i=0;i<s.length();i++) {
			int ch=s.charAt(i)-'0';
			answer[ch]+=1;
		}

		return answer;
	}

}
