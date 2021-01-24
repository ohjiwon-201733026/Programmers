package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class B11652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		HashMap<Long,Integer> hm=new HashMap<>();

		for(int i=0;i<N;++i) {
			long key=sc.nextLong();
			if(hm.containsKey(key)) hm.put(key, hm.get(key)+1);
			else hm.put(key, 1);
		}

		Set<Long> keys=hm.keySet();
		Iterator<Long> it=keys.iterator();
		int max=0;
		while(it.hasNext()) {
			long key=it.next();
			if(max<hm.get(key)) max=hm.get(key);

		}

		ArrayList<Long> al=new ArrayList<>();
		Set<Long> keys2=hm.keySet();
		Iterator<Long> it2=keys2.iterator();

		while(it2.hasNext()) {
			long key=it2.next();
			if(max==hm.get(key)) al.add(key);
		}

		Collections.sort(al);
		System.out.println(al.get(0));


	}

}
