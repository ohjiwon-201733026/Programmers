package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B10814_1 {
	public static class Person{
		int idx;
		int age;
		String name;

		Person(int idx,int age,String name){
			this.idx=idx;
			this.age=age;
			this.name=name;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Person [] persons=new Person[n];

		for(int i=0;i<n;++i) {
			int age=sc.nextInt();
			String name=sc.next();
			persons[i]=new Person(i,age,name);
		}

		Arrays.sort(persons,new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub
				return p1.age-p2.age==0?p1.idx-p2.idx:p1.age-p2.age;
			}

		});

		for(int i=0;i<n;++i) {
			System.out.println(persons[i].age+" "+persons[i].name);
		}

	}

}
