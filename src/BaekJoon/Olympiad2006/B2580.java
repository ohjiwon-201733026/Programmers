// 스도쿠
package BaekJoon.Olympiad2006;

import java.util.Scanner;

public class B2580 {
	private static int [][] arr=new int [9][9];

	private static boolean possibility(int row, int col, int value ) {

		// 열 체크
		for(int i=0;i<9;i++) {
			if(arr[row][i] == value) return false;
		}

		// 행 체크
		for(int i=0;i<9;i++) {
			if(arr[i][col] == value) return false;
		}

		// 3 x 3 체크
		int set_row= (row/3) * 3 ;
		int set_col= (col/3) * 3 ;

		for(int i=set_row; i< set_row+3 ;++ i) {
			for(int j= set_col; j<set_col+3; ++j)
				if(arr[i][j]==value) return false;
		}

		return true;


	}

	public static void sudoku(int row, int col) {

		// 해당 행이 다 채워지면 다음행의 첫번째부터 다시 시 작
		if(col==9) {
			sudoku(row+1,0);
			return;
		}

		// 행과 열이 모두 다 채워졌으면 출력 후 종료
		if(row==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}

			System.exit(0);
		}

		if(arr[row][col]==0) {
			for(int i=1;i<10;++i) {

				if(possibility(row,col,i)) {
					arr[row][col]=i;
					sudoku(row,col+1);
				}
			}
			arr[row][col]=0;
			return;
		}

		sudoku(row,col+1);



	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int i = 0; i < 9; i ++) {
			for( int j = 0; j < 9 ; j ++)
				arr[i][j]=sc.nextInt();
		}


		sudoku(0,0);


	}

}

