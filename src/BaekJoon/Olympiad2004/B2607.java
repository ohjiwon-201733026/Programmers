// 비슷한 단어
package BaekJoon.Olympiad2004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class B2607 {

	public static HashMap<Character, Integer> origin, other;

	public static void init(HashMap<Character,Integer> hm) {
		for(char ch='A';ch<='Z';ch++)
			hm.put(ch, 0);
	}

	public static boolean isSimilarTo(HashMap<Character,Integer> hm) {
		int a,b,diff=0,originLen = 0,otherLen=0;
		for(char ch='A';ch<='Z';ch++) {
			originLen+=(a=origin.get(ch));
			otherLen+=(b=other.get(ch));
			diff+=Math.abs(a-b);
		}
		return diff<=2&&Math.abs(originLen-otherLen)<=1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

		char ch;
		int n=Integer.parseInt(in.readLine())-1;
		String word=in.readLine();
		int len=word.length();
		int cnt=0;

		origin=new HashMap<>();
		other=new HashMap<>();

		init(origin);
		for(int i=0;i<len;i++) {
			ch=word.charAt(i);
			origin.put(ch, origin.get(ch)+1);
		}

		for(int i=0;i<n;i++) {
			init(other);
			word=in.readLine();
			len=word.length();
			for(int j=0;j<len;j++) {
				ch=word.charAt(j);
				other.put(ch, other.get(ch)+1);
			}
			if(isSimilarTo(other)) cnt++;
		}

		out.write(cnt+"");
		out.close();
		in.close();

	}

}
