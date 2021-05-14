package BaekJoon.Greedy;

import java.util.Scanner;

public class B1080_행렬 {
	public static int [][] a;
	public static int [][] b;
	public static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int cnt=0;

		a=new int[N][M];
		b=new int[N][M];

		for(int i=0;i<N;++i) { // A 입력
			String s=sc.next();
			for(int j=0;j<M;++j) {
				a[i][j]=s.charAt(j)-'0';
			}
		}

		for(int i=0;i<N;++i) { // B 입력
			String s=sc.next();
			for(int j=0;j<M;++j) {
				b[i][j]=s.charAt(j)-'0';
			}
		}

		if(N<3 || M<3) { //3*3보다 작을 때
			if(sameMatrix()) cnt=0;
			else cnt=-1;
		}
		else {

		for(int i=0;i<N-2;++i) {
			for(int j=0;j<M-2;++j) {
				if(a[i][j]!=b[i][j]) {
					cnt++;
					three(i,j);
				}
			}
		}


		if(!sameMatrix()) cnt=-1;
		}
		System.out.println(cnt);


	}

	private static boolean sameMatrix() {
		// TODO Auto-generated method stub

		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(a[i][j]!=b[i][j]) return false;
			}
		}
		return true;
	}

	private static void three(int i, int j) {
		// TODO Auto-generated method stub

		for(int x=i;x<i+3;++x) {
			for(int y=j;y<j+3;++y) {
				if(a[x][y]==0) a[x][y]=1;
				else a[x][y]=0;
			}
		}
	}

}
