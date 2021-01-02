package Programmers.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class Hash1A {
	public static String solution(String[] participant, String[] completion) {
		String answer="";
		HashMap<String, Integer> hm=new HashMap<>();
		for(String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		for(String player :completion) hm.put(player, hm.get(player) - 1);

		for(String key : hm.keySet()) {
			if(hm.get(key)!=0) {
				answer=key;
			}
		}
		return answer;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int participants=sc.nextInt();
		String [] participant= new String[participants];
		for(int i=0;i<participants;i++) {
			participant[i]=sc.next();
		}

		String [] completion= new String[participants-1];
//		System.out.println(completion);
		for(int i=0;i<participants-1;i++) {
			completion[i]=sc.next();
		}

		String answer=solution(participant,completion);
		System.out.println(answer);


	}


}
