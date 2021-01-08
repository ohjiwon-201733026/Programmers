//대표값
package BaekJoon.Olympiad2005;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class B2592 {
	private static int sum(int [] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];

		return sum/10;
	}

	private static int numberFrequncy(int [] arr) {
		int max=0;
		int maxKey=0;
		HashMap<Integer, Integer> hm=new HashMap<>();
		for(int c:arr) {
			if(hm.containsKey(c))
				hm.put(c,hm.get(c)+1);
			else hm.put(c, 1);
		}

		Set<Integer> keys=hm.keySet();
		Iterator<Integer> it=keys.iterator();
		while(it.hasNext()) {
			int key=it.next();
			int value=hm.get(key);
			if(max<value) {
				max=value;
				maxKey=key;
			}
		}

		return maxKey;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] arr= new int [10];
		for(int i=0;i<10;i++) {
			arr[i]=sc.nextInt();
		}

		System.out.println(sum(arr));
		System.out.println(numberFrequncy(arr));


	}

}
