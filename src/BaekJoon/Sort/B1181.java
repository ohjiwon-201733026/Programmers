package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String [] words=new String[n];
		for(int i=0;i<n;i++) {
			words[i]=sc.next();
		}

		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length())==0?
						o1.compareTo(o2):Integer.compare(o1.length(), o2.length());
			}

		});

		ArrayList<String> arrayList = new ArrayList<>();

		for(String data : words){
		    if(!arrayList.contains(data))
		        arrayList.add(data);
		}


		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
	}

}
