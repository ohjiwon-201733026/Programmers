package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1946_신입사원 {
	public static class Person implements Comparable<Person>{
		int A;
		int B;

		Person(int a, int b){
			this.A=a;
			this.B=b;
		}

		@Override
		public int compareTo(Person p) {
			return this.A-p.A;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();

		while(T-->0) {
			int N=Integer.parseInt(br.readLine());
			Person [] score=new Person [N];
			for(int i=0;i<N;++i) {
				String[] str = br.readLine().split(" ");
				int first = Integer.parseInt(str[0]);
				int sec = Integer.parseInt(str[1]);
				score[i]=new Person(first,sec);
			}
			Arrays.sort(score);
			int cnt=1;

				int B=score[0].B;

				for(int j=2;j<N;++j) {
					if(score[j].B<B) {
						B=score[j].B;
						cnt++;
					}
				}

			sb.append(cnt+"\n");
		}

		System.out.println(sb);
	}

}
