//신입사원
package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1946 {
	public static class Person implements Comparable<Person>{
		int su;
		int me;

		public Person(int su, int me) {
			this.su=su;
			this.me=me;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.su-o.su;
		}
	}


	public static List<Person> inputSortedEmployee(){

		int num=sc.nextInt();
		List<Person> persons=new ArrayList<>();
		for(int i=0;i<num;i++) {
			int su=sc.nextInt();
			int me=sc.nextInt();
			persons.add(new Person(su,me));
		}
		Collections.sort(persons);
		return persons;
	}

	public static int solve(List<Person> persons) {
		int cnt=0;
		int minInterViewRank=Integer.MAX_VALUE;

		for(Person p:persons) {
			if(p.me<minInterViewRank) {
				cnt++;
				minInterViewRank=p.me;
			}
		}
		return cnt;
	}
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int testCase=sc.nextInt();

		for(int i=0;i<testCase;i++) {
			List<Person> persons=inputSortedEmployee();
			System.out.println(solve(persons));
		}

	}

}
