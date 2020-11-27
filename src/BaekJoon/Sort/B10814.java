// 나이순 정렬
package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B10814 {
	public static class Person{
		int index;
		int age;
		String name;

		public Person(int i,int age, String name) {
			this.index=i;
			this.age=age;
			this.name=name;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Person [] persons=new Person[n];
		for(int i=0;i<n;i++) {
			int age=sc.nextInt();
			String name=sc.next();
			persons[i]=new Person(i,age,name);
		}

		Arrays.sort(persons,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return  Integer.compare(o1.age, o2.age)==0?Integer.compare(o1.index, o2.index):Integer.compare(o1.age, o2.age);
			}

		});


		for(int i=0;i<persons.length;i++) {
			System.out.println(persons[i].age+" "+persons[i].name);
		}
	}

}
