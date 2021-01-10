//빙고
package BaekJoon.Olympiad2006;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2578 {

	private static int [][] bingo;
	private static boolean [][] check;
	private static int count=0;

	public static boolean checking(int n) {

		int i,j = 0;
		loop:

		for(i=0;i<5;i++) {
			for(j=0;j<5;j++) {
				if(bingo[i][j]==n) {
					check[i][j]=true;
					break loop;
				}
			}
		}

		if(bingo(i,j)>=3) return true;
		else return false;

	}

	public static int bingo(int i,int j) {
		boolean ck=false;
		int line=0;
		int cnt=0;


		for(int x=0;x<5;x++) { // 가로 bingo
			for(int y=0;y<5;y++) {
				if(check[x][y]) ++cnt;
			}
			if(cnt==5) ++line;
			cnt=0;
		}


		cnt=0;
		for(int x=0;x<5;x++) { // 세로 bingo
			for(int y=0;y<5;y++) {
				if(check[y][x]) ++cnt;
			}
			if(cnt==5) ++line;
			cnt=0;
		}

		cnt=0;
		for(int t=0;t<5;t++) { // 왼쪽 대각선 bingo
			if(check[t][t]) ++cnt;
		}
		if(cnt==5) ++line;

		cnt=0;
		for(int t=0;t<5;t++) { //오른쪽 대각선 bingo
			if(check[t][4-t]) ++cnt;
		}
		if(cnt==5) ++line;

		if(ck) ++count;

		return line;




	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		bingo=new int [5][5];
		check=new boolean [5][5];

		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				bingo[i][j]=sc.nextInt();
			}
		}

		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<25;i++) {
			int n=sc.nextInt();
			q.add(n);
		}

		int idx=0; // 사회자의 몇번째 번호인지
		while(true) {

			int n=q.remove();
			++idx;

			if(checking(n)) break;


		}

		System.out.println(idx);

	}

}
