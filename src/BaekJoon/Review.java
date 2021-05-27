package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Review {
	public static class Person implements Comparable<Person>{
		int a;
		int b;

		Person(int a, int b){
			this.a=a;
			this.b=b;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}


	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0) {
			int N=sc.nextInt();
			ArrayList<Person> persons=new ArrayList<>();
			for(int i=0;i<N;++i) {
				persons.add(new Person(sc.nextInt(),sc.nextInt()));
			}

			Collections.sort(persons);

			int score=persons.get(0).b;
			int cnt=1;
			for(int i=1;i<N;++i) {
				if(persons.get(i).b<score) {
					score=persons.get(i).b;
					cnt++;
				}
			}

			System.out.println(cnt);
		}

	}

}
