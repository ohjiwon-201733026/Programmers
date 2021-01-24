package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		int[] al=new int[n];
		for(int i=0;i<n;++i) {
			al[i]=Integer.parseInt(br.readLine());
		}

		Arrays.sort(al);

		StringBuilder sb=new StringBuilder();

		for(int i=0;i<n;++i) {
			sb.append(al[i]).append('\n');
		}
		System.out.println(sb);


	}

}
