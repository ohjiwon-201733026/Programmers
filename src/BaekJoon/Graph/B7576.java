package BaekJoon.Graph;

import java.util.Scanner;

public class B7576 {

	public static int [][] tomato;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();

		tomato=new int[N][M];

		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				tomato[i][j]=sc.nextInt();


	}

}
