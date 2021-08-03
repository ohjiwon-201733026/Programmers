package BaekJoon.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class B10808_알파벳개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();

		HashMap<Character,Integer> hm=new HashMap<>();

		for(char c='a';c<='z';++c) {
			hm.put(c, 0);
		}

		for(int i=0;i<s.length();++i) {
			hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
		}

		Set<Character> keys=hm.keySet();
		Iterator<Character> it=keys.iterator();

		while(it.hasNext()){
			char c=it.next();
			System.out.print(hm.get(c)+" ");
		}

	}

}
