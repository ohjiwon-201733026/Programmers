package Review;

import java.util.Scanner;

public class B2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int length=s.length();
		int  [] str=new int[length];
		int [] dp=new int [length];
		for(int i=0;i<length;++i) {
			str[i]=s.charAt(i)-'0';
		}

		for(int i=1;i<length;++i) {
			if(str[i-1]>0) dp[i]=dp[i-1];

			int num=str[i]*10+str[i-1];
			if(num>=10&& num<=26) dp[i]+=dp[i-2];
		}

		System.out.println(dp[length-1]);



	}

}
