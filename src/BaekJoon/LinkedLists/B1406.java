package BaekJoon.LinkedLists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class B1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine();
		LinkedList<Character> list=new LinkedList<>();
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			list.add(c);
		}


		int n=Integer.parseInt(br.readLine());
		int i=s.length();
		while(n-->0) {
			String [] a=br.readLine().split(" ");

			switch(a[0]) {
			case "L" : {
				if(i!=0)
				i--;
				break;
			}
			case "D" : {
				if(i!=list.size())
					i++;
				break;
			}
			case "B" :{
				if(i!=0) {
					list.remove(i-1);
					--i;
				}
					break;
			}
			case "P":{
				char x=a[1].charAt(0);
				list.add(i,x);
				i++;
				break;
			}
			}
		}
		System.out.println(list.toString());
	}

}
