// 별찍기 4
package BaekJoon.InOutput;

import java.util.Scanner;

public class B2441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();

        for(int i=0; i<num; i++) {

            for(int j=num-i; j<num; j++) {

                System.out.print(" ");

            }

            for(int k=i; k<num; k++) {

                System.out.print("*");

            }

            System.out.println();
        }

	}

}
