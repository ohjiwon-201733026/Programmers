package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int length=s.length();
		long [] dp=new long [length+1]; dp[0]=dp[1]=1;

		if(s.charAt(0)=='0') {System.out.println(0);}
		else if(s.charAt(length-1)=='0'&&(s.charAt(length-2)!='1'||s.charAt(length-2)!='2')) {
			System.out.println(0);

		}
		else {

		for(int i=2;i<=length;++i) {
			int tmp=Integer.parseInt(s.charAt(i-1)+"");
//			int tmp=s.charAt(i-1)-'0';
			if(tmp>0) dp[i]=dp[i-1]%1000000;

			tmp+=Integer.parseInt(s.charAt(i-2)+"")*10;

			if(tmp>=10&& tmp<=26) dp[i]=(dp[i]+dp[i-2])%1000000;
		}

		System.out.println(dp[length]);

		}
	}

}
