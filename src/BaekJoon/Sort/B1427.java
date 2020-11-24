//소트인사이드
package BaekJoon.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String num=sc.next();


		String[] n=solution(num);
		for(int i=0;i<n.length;i++) {
		System.out.print(n[i]);
	}
		}


	public static String[] solution(String num) {
		String [] answer=new String[num.length()];
		for(int i=0;i<num.length();i++) {
			answer[i]=num.substring(i,i+1);
		}

		Arrays.sort(answer,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}});




		return answer;

	}

}
