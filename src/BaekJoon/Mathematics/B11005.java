package BaekJoon.Mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		long B=sc.nextInt();
		List<Character> list=new ArrayList<>();
		while(N>0) {
			if(N%B<10) list.add((char)(N%B+'0'));
			else if(N%B>=10) {
				list.add((char)('A'+(N%B-10)));
			}
			N=N/B;
		}

		for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i));
	}



}
