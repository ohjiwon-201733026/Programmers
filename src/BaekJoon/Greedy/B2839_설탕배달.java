package BaekJoon.Greedy;

import java.util.Scanner;

public class B2839_설탕배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int cnt=0;
		while (true) {
            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            N -= 3;
            cnt++;

            if (N < 0) {
                cnt = -1;
                break;
            }
        }
		System.out.println(cnt);

	}

}
