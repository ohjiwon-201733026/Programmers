package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Point [] points=new Point[n];
		for(int i=0;i<n;i++) {
			String x=sc.next();
			String y=sc.next();
			points[i]=new Point(x,y);
		}

		Point[] result=solution(points);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i].x+" "+result[i].y);
		}

	}

	public static class Point{
		String x;
		String y;

		public Point(String x,String y) {
			this.x=x;
			this.y=y;
		}

	}

	public static Point[] solution(Point[] array){
		Arrays.sort(array,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				String p1X=o1.x;
				String p1Y=o1.y;
				return p1X.compareTo(o2.x)==0?p1Y.compareTo(o2.y):p1X.compareTo(o2.x);
			};
		});


		return array;

		}
}
