package Programmers.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sort2 {


	 public static String solution(int[] numbers) {
	        String answer = "";

	        String str_numbers[]=new String[numbers.length];

	        for(int i=0;i<str_numbers.length;i++) {
	        	str_numbers[i]=String.valueOf(numbers[i]);
	        }

	        Arrays.sort(str_numbers,new Comparator<String>() {
	        	@Override
	        	public int compare(String o1,String o2) {
	        		return (o2+o1).compareTo(o1+o2);
	        	}
	        });

	        if(str_numbers[0].startsWith("0")) { //젤 큰수가 0인경우 그냥 0 리턴
	        	answer+="0";
	        }else {
	        	for(int j=0;j<str_numbers.length;j++) {
	        		answer+=str_numbers[j];
	        	}
	        }




	        return answer;

	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int [] numbers=new int[num];
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=sc.nextInt();
		}

		String answer=solution(numbers);
		System.out.println(answer);

	}

}
