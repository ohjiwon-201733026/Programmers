// 비슷한 단어
package BaekJoon;

import java.util.Scanner;
import java.util.Vector;

public class B2607 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String pattern=sc.next();
		String [] words=new String[n-1];
		int [] count=new int[n-1];
		Vector<Character> v=new Vector<>();
		int answer=0;

		for(int i=0;i<pattern.length();i++) {
			v.add(pattern.charAt(i));
		}

		for(int i=0;i<n-1;i++) {
			words[i]=sc.next();
		}

		for(int i=0;i<n-1;i++) {
			for(int j=0;j<words[i].length();j++) {
				if(v.contains(words[i].charAt(j))) {
					count[i]++;

				}
			}
		}

		for(int i=0;i<count.length;i++) {
			if(Math.abs(count[i]-pattern.length())<=1) {
				System.out.println(words[i]);
				answer++;
			}
		}

		System.out.println(answer);

	}

}
