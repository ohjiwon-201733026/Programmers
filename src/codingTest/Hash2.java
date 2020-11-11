package codingTest;

import java.util.Scanner;

public class Hash2 {

	public static boolean solution(String[] phone_book) {
	boolean answer = true;
    int num=phone_book[0].length();

    for(int i=1;i<phone_book.length;i++){
        String sub=phone_book[i].substring(0,num);
        if(phone_book[0].equals(sub)) answer=false;

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
