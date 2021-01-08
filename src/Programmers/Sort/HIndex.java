package Programmers.Sort;

import java.util.Arrays;

public class HIndex {

	public static int solution(int [] citations) {
		int answer=0;
		int length=citations.length;
		int h=0;
		int k=0;
		Arrays.sort(citations);

		for(int i=0;i<citations.length;i++) {
			h=citations[i];
			k=citations.length-i;

			if(k<=h) {
				answer=k;
				break;
			}
		}
		System.out.println(answer);
		return answer;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] citations= {3,0,6,1,5};

		solution(citations);


	}

}
