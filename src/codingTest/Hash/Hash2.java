package codingTest.Hash;

import java.util.Scanner;

public class Hash2 {

	public static boolean solution(String[] phone_book) {
	boolean answer = true;

	for(int i=0;i<phone_book.length;i++) {
		for(int j=i+1;j<phone_book.length;j++) {
			if(phone_book[i].startsWith(phone_book[j])) return false;
			if(phone_book[j].startsWith(phone_book[i])) return false;
		}
	}

    return answer;

}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int arrayLength=sc.nextInt();
		String [] array= new String[arrayLength];
		for(int i=0;i<arrayLength;i++) {
			array[i]=sc.next();
		}


		boolean answer=solution(array);
		System.out.println(answer);
	}

}
