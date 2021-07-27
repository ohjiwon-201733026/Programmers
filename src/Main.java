import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		while(sc.hasNext()){
			String s=sc.next();
			String t=sc.next();

			System.out.println(solution(s,t));
		}



	}

	public static String solution(String s, String t){
		int k=0; // s index
		int i=0; // t index
		while(true){
			if(k==s.length())  return "Yes";
			if(i==t.length()) break;
			if(s.charAt(k)==t.charAt(i)) k++;
			i++;
		}

		return "No";
	}



}
