package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B1850 {
	public static long getGCD(long a,long b) {

		while(b>0) {
			long tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] s=br.readLine().split(" ");
		long A=Long.parseLong(s[0]);
		long B=Long.parseLong(s[1]);

		long ans=getGCD(A,B);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ans;++i) {
			sb.append("1");
		}
		System.out.println(sb.toString());

	}

}
