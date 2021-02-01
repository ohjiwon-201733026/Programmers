package BaekJoon.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1850 {

	public static long GCD(long a,long b) {
		while(b>0) {
			long tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] a=br.readLine().split(" ");
		long A=Long.parseLong(a[0]);
		long B=Long.parseLong(a[1]);
		StringBuilder sb=new StringBuilder();

		long t=GCD(A,B);

		for(int i=0;i<t;++i) {
			sb.append("1");
		}
		System.out.println(sb);


	}

}
