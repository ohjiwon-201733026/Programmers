package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class B10825 {
	static class Student{
		String name;
		int kor;
		int eng;
		int math;

		public Student(String name, int kor, int eng, int math) {
			// TODO Auto-generated constructor stub
			this.name=name;
			this.kor=kor;
			this.eng=eng;
			this.math=math;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Student [] students=new Student[n];

		for(int i=0;i<n;++i) {
			String name=sc.next();
			int kor=sc.nextInt();
			int eng=sc.nextInt();
			int math=sc.nextInt();
			students[i]=new Student(name,kor,eng,math);
		}

		Arrays.sort(students,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub

				if(o2.kor-o1.kor!=0) return o2.kor-o1.kor;
				else if(o1.eng-o2.eng!=0) return o1.eng-o2.eng;
				else if(o2.math-o1.math!=0) return o2.math-o1.math;
				else return o1.name.compareTo(o2.name);
			}

		});

		for(int i=0;i<n;++i) {
			System.out.println(students[i].name);
		}




	}

}
