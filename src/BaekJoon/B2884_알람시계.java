package BaekJoon;

import java.util.Scanner;

public class B2884_알람시계 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int H=sc.nextInt();
		int M=sc.nextInt();
		M=M-45;
		if(M<0) {
			H--;
			M=60+(M);
			if(H<0) H=24+(H);
		}

		System.out.println(H+" "+M);


	}

}
