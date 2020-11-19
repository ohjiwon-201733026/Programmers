package codingTest.Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Hash3 {

	 public static int solution(String[][] clothes) {

		 	HashMap<String,Integer> hm=new HashMap<>();
		 	int answer = 1;

		 	for(int i=0;i<clothes.length;i++) {
		 		hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0)+1);
		 	}

		 	int m=hm.size();
		 	int [] arg=new int[m];
		 		Set<String> keys=hm.keySet();
		 		Iterator<String> it=keys.iterator();
		 		int i=0;
		 	while(it.hasNext()) {

		 		String key=it.next();
		 		int value=hm.get(key);
		 		arg[i]=value;
		 		++i;
		 	}
		 	System.out.println(hm);
		 	for(int j=0;j<arg.length;j++) {

		 	answer*=(arg[j]+1);
		 	}


		 	answer=answer-1;

	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int arrayLength=sc.nextInt();
		String [][] clothes= new String[arrayLength][2];
		for(int i=0;i<arrayLength;i++) {
			for(int j=0;j<2;j++)
			clothes[i][j]=sc.next();
		}

//		for(int i=0;i<arrayLength;i++) {
//			for(int j=0;j<2;j++)
//			 System.out.println(clothes[i][j]);
//		}

		int answer=solution(clothes);
		System.out.println(answer);
	}

}
