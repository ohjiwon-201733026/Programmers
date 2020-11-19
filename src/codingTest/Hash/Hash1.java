package codingTest.Hash;

import java.util.Arrays;
import java.util.Scanner;

public class Hash1 {

	    public static String solution(String[] participant, String[] completion) {

		    	   Arrays.sort(participant);
		    	   Arrays.sort(completion);
		    	   int i;
		    	for(i=0;i<completion.length;i++) {
		    		if(!participant[i].equals(completion[i]))
		    			return participant[i];
		    		}
		    	return participant[i];





	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int participants=sc.nextInt();
//		System.out.println(participants);
		String [] participant= new String[participants];
		for(int i=0;i<participants;i++) {
			participant[i]=sc.next();
		}
//		for(int i=0;i<participants;i++) {
//			System.out.println(participant[i]);
//		}

		String [] completion= new String[participants-1];
//		System.out.println(completion);
		for(int i=0;i<participants-1;i++) {
			completion[i]=sc.next();
		}

		String answer=solution(participant,completion);
		System.out.println(answer);

	}

}
