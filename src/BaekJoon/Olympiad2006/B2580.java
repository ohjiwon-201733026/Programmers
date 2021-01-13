// 스도쿠
package BaekJoon.Olympiad2006;

import java.util.Scanner;
import java.util.Vector;

public class B2580 {

	private static boolean rowCheck(int [][] sdc, int x, int y) {
		Vector<Integer> v=new Vector<>();

		for(int i=0;i<9;i++) {
			if( v.contains(sdc[i][y]) ) {
				return false;
			}
			else {
				v.add(sdc[i][y]);
			}
		}
		return true;

	}

	private static boolean columnCheck(int [][] sdc, int x, int y) {
		Vector<Integer> v=new Vector<>();

		for(int i=0;i<9;i++) {
			if( v.contains(sdc[x][i]))
				return false;

			else
				v.add(sdc[x][i]);
		}
		return true;

	}

	private static boolean squareCheck(int [][] sdc, int i, int j) {
		Vector<Integer> v=new Vector<>();

		if(i>=0 && i<3 ) i=0;
		else if(i<6) i=3;
		else i=6;

		if(j>=0 && j<3 ) j=0;
		else if(j<6) j=3;
		else j=6;

		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				if( v.contains(sdc[i+x][j+y]) ) return false;
				else v.add(sdc[i+x][j+y]);
			}
		}

		return true;

	}
	private static Vector<Integer> remain(int [][] sdc, int i, int j){
		boolean [] tmp=new boolean[10];
		Vector<Integer> v=new Vector<>();

		for(int x=0;x<9;x++) {
			int c=sdc[i][x];
			tmp[c]=true;
		}

		for(int x=1;x<tmp.length;x++) {
			if(tmp[x]==false) v.add(x);
		}

		return v;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [][] sdc=new int [9][9];
		for(int i = 0; i < 9; i ++) {
			for( int j = 0; j < 9 ; j ++)
				sdc[i][j]=sc.nextInt();
		}

		for(int i = 0; i < 9; i ++) {
			for( int j = 0; j < 9 ; j ++)
				if(sdc[i][j]==0) { // 0이면
					Vector<Integer> v=remain(sdc,i,j);
					System.out.println(v);
					for(int k=0;k<v.size();k++) {
						int c=v.get(k);
						System.out.println(c);
						sdc[i][j]=c;
						if(rowCheck(sdc,i,j)|| columnCheck(sdc,i,j) || squareCheck(sdc,i,j) ) break;
						else sdc[i][j]=0;
					}
				}

		}

		for(int i = 0; i < 9; i ++) {
			for( int j = 0; j < 9 ; j ++) {
				System.out.print(sdc[i][j]+" ");
			}
			System.out.println();

		}

	}

}

