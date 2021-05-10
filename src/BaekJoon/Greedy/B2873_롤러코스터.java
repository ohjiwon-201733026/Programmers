package BaekJoon.Greedy;

import java.util.Scanner;

public class B2873_롤러코스터 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt();
		int C=sc.nextInt();

		for(int i=0;i<R;++i) {
			for(int j=0;j<C-1;++j) {
				if(i%2==1)
				System.out.print("L");
				else System.out.print("R");
			}
			if(i==R-1) break;
			System.out.print("D");
		}
	}

}
