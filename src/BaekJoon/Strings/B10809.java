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
		HashMap<Character,Integer> test=new HashMap<>();

		for(int i=0;i<s.length();++i) {
			if(!test.containsKey(s.charAt(i)))
				test.put(s.charAt(i), i);
		}

		for(char c='a';c<='z';++c) {
			if(test.containsKey(c))
				hm.put(c, test.get(c));
			else hm.put(c, -1);
		}


		Set<Character> keys=hm.keySet();
		Iterator<Character> it=keys.iterator();

		while(it.hasNext()){
			char c=it.next();
			System.out.print(hm.get(c)+" ");
		}

	}

}
