package BaekJoon.BFS;

import java.util.Scanner;

public class B16918_봄버맨 {

	public static int R,C,N,time=1;
	public static char [][] arr;
	public static int [][]num;
	public static int [] dx= {0,1,-1,0};
	public static int [] dy= {1,0,0,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		N=sc.nextInt();

		arr=new char [R][C];
		num=new int [R][C];

		for(int i=0;i<R;++i) {
			String s=sc.next();
			for(int j=0;j<C;++j) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='O') num[i][j]=3;
			}
		}

		while(time++<N) {
			if(time%2==0) {
				setbomb();
			}
			else {
				getbomb();
			}
		}

		print();

	}

	private static void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static void getbomb() {
		// TODO Auto-generated method stub
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				if(num[i][j]==time) {
					bomb(i,j);
				}
			}
		}

	}

	private static void bomb(int i,int j) {
		// TODO Auto-generated method stub
		arr[i][j]='.';

		for(int k=0;k<4;++k) {
			int x=i+dx[k];
			int y=j+dy[k];

			if(0<=x && x<R && 0<=y && y<C) {
				if(arr[x][y]=='O' && num[x][y]!=time) {
					arr[x][y]='.';
					num[x][y]=0;
				}
			}
		}

	}

	private static void setbomb() {
		// TODO Auto-generated method stub
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				if(arr[i][j]=='.') {
					arr[i][j]='O';
					num[i][j]=time+3;
				}
			}
		}
	}



}
