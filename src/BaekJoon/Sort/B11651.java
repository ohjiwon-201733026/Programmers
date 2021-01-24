package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class B11651 {

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
		ArrayList<Pair> list=new ArrayList<>();

		for(int i=0;i<n;++i) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			list.add(new Pair(x,y));
		}

		Collections.sort(list,new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				return p1.y-p2.y==0?p1.x-p2.x:p1.y-p2.y;
			}

		});

		for(int i=0;i<n;++i) {
			System.out.println(list.get(i).x+" "+list.get(i).y);
		}

	}

}
