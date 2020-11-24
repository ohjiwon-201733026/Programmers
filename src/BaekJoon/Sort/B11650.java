package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11650 {
	public static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Point[] points=new Point[n];
		for(int i=0;i<n;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			points[i]=new Point(x,y);
		}

		Arrays.sort(points,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
//				if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
//				return Integer.compare(o1[0],o2[0]);
				return Integer.compare(o1.x,o2.x)==0?Integer.compare(o1.y,o2.y):Integer.compare(o1.x,o2.x);
			};
		});

		for(int i=0;i<points.length;i++) {
			System.out.println(points[i].x+" "+points[i].y);
		}

	}


}
