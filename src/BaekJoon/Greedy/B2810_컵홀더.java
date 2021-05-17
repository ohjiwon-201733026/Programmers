package BaekJoon.Greedy;

import java.util.Scanner;

public class B2810_컵홀더 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String s=sc.next();
		int cnt=0;

		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if(c=='L') i++;
			cnt++;
		}
		cnt++;
		if(cnt>N) System.out.println(N);
		else System.out.println(cnt);

	}

}
