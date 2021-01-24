package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11650_1 {

	public static class Pair{
		int x;
		int y;

		Pair(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Pair [] p=new Pair[n];

		for(int i=0;i<n;++i) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			p[i]=new Pair(x,y);
		}

		Arrays.sort(p,new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				return p1.x-p2.x==0?p1.y-p2.y:p1.x-p2.x;
			}

		});

		for(int i=0;i<n;++i) {
			System.out.println(p[i].x+" "+p[i].y);
		}

	}

}
