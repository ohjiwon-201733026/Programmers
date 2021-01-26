package Review;

import java.util.Scanner;

public class B9012_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		while(N-->0) {
			String s=sc.next();

			int sum=0;

			for(int i=0;i<s.length();++i) {
				char c=s.charAt(i);
				if(c=='(') sum++;
				else sum--;

				if(sum<0) break;

			}

			if(sum!=0) System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
