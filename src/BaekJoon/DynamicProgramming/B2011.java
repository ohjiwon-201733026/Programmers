package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int length = str.length();
		long[] dp = new long[length+1]; dp[0] = dp[1] = 1;

		if(str.charAt(0) == '0') System.out.print(0);
		else if(str.charAt(length-1) == '0' && str.charAt(length-2) != '1' && str.charAt(length-2) != '2') System.out.print(0);
		else {
			for(int i = 2; i <= length; i++) {
				int tmp = Integer.parseInt(str.charAt(i-1) + "");
				if(tmp > 0) dp[i] = dp[i-1] % 1000000;

        tmp += Integer.parseInt(str.charAt(i-2) + "")*10;
				if(10 <= tmp && tmp <= 26) dp[i] = (dp[i] + dp[i-2]) % 1000000;
			}
			System.out.print(dp[length]);
		}

		}




}
