package BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void recur(int n, int from, int by, int to) throws IOException {
		if(n==1) {
			bw.write(from+" "+to+"\n");
			return;
		}
		else {
			recur(n-1,from,to,by);
			bw.write(from+" "+to+"\n");
			recur(n-1,by,from,to);
		}



	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int n=Integer.parseInt(s);

		bw.write((int) (Math.pow(2, n) - 1) + "\n");
		recur(n,1,2,3);

		bw.flush();
	}

}
