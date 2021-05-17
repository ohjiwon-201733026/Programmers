package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
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
			if(this.a==o.a) {
				return this.b-o.b;
			}
			return this.a-o.a;
		}

	}


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int N=sc.nextInt();
			int cnt=0;

			ArrayList<Person> persons=new ArrayList<>();
			for(int i=0;i<N;++i) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				persons.add(new Person(a,b));
			}

			Collections.sort(persons);

			cnt++;
			int minValue=persons.get(0).b;
			for(Person p:persons) {
				if(p.b<minValue) {
					cnt++;
					minValue=p.b;
				}
			}

			System.out.println(cnt);

		}
	}

}
