package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1946 {
	public static class Person{
		int su;
		int me;
		boolean flag;

		public Person(int su, int me) {
			this.su=su;
			this.me=me;
			this.flag=true;
		}
	}

	public static class PersonSuComparator implements Comparator<Person>{

		@Override
		public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub
			return o1.su-o2.su;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		Person [][] persons=new Person[testCase][];

		for(int i=0;i<testCase;i++) {
			int n=sc.nextInt();
			persons[i]=new Person[n];

			for(int j=0;j<n;j++) {
				int su=sc.nextInt();
				int me=sc.nextInt();
				persons[i][j]=new Person(su,me);
			}


			Arrays.sort(persons[i],new PersonSuComparator());
			int count=persons[i].length;
			for(int j=persons[i].length-1;j>=0;j--) {
				for(int x=j-1;x>=0;x--) {
					Person tmp=persons[i][j];
					if(tmp.me>persons[i][x].me && persons[i][x].flag==true) {
						--count;
						persons[i][x].flag=false;
					}
				}
			}

			System.out.println(count);

			for(int j=0;j<persons[i].length;j++) {
				System.out.println(persons[i][j].su+" "+persons[i][j].me);
		}
		}

	}

}
