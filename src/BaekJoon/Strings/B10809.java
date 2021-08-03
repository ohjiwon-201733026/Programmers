package BaekJoon.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class B10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		HashMap<Character,Integer> hm=new HashMap<>();


		for(char c:s.toCharArray()){
			if(hm.containsKey(c)) hm.put(c,hm.get(c)+1);
			else hm.put(c,1);
		}

		for(char c='a';c<='z';++c){
			if(hm.containsKey(c)) System.out.print(hm.get(c)+" ");
			else System.out.print("0 ");
		}
	}

}
