package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Review {
	public static class Person implements Comparable<Person>{
		int a;
		int b;

		public Person(int a, int b) {
			this.a=a;
			this.b=b;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			if(o.a==this.a) return o.b-this.b;
			return o.a-this.a;
		}


	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int N=sc.nextInt();
			Person [] p=new Person[N];
			int cnt=0;

			for(int i=0;i<N;++i) {
				p[i]=new Person(sc.nextInt(),sc.nextInt());
			}
			Arrays.sort(p);
			int min=p[0].b;
			for(int i=0;i<N;++i) {
				if(min>p[i].b) {
					cnt++;
					min=p[i].b;
				}
			}

			System.out.println(cnt);
		}


	}

}
