// 색종이
package BaekJoon.Olympiad2007;

import java.util.Scanner;

public class B2563 {

	public static boolean [][] white;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][] arr=new int [n][2];
		white=new boolean [100][100];

			for(int i=0;i<n;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				arr[i][0]=x;
				arr[i][1]=y;
			}



		int result=solution(arr);

//		for(int i=0;i<100;i++) {
//			for(int j=0;j<100;j++) {
//				System.out.print(white[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(result);

	}

	private static int solution(int[][] arr) {
		// TODO Auto-generated method stub
		int count=0;
			for(int k=0;k<arr.length;k++) {
				int i=arr[k][0];
				int j=arr[k][1];
				for(int x=0;x<10;x++) {
					for(int y=0;y<10;++y) {
						if(!white[i+x][j+y]) {
							white[i+x][j+y]=true;
							++count;
						}
					}
				}
			}

		return count;
	}

}
