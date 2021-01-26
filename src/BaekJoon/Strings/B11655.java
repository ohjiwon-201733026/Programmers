package BaekJoon.Strings;

import java.util.Scanner;

public class B11655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();

		StringBuilder ans=new StringBuilder();

		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if('A'<=c&&c<='Z') {
				if(c+13>90) ans.append((char)('A'-1+(c+13-'Z')));
				else ans.append((char)(c+13));
			}
			else if('a'<=c&&c<='z') {
				if(c+13>122) ans.append((char)('a'-1+(c+13-'z')));
				else ans.append((char)(c+13));
			}
			else if(c==' ') ans.append(" ");
			else ans.append(c);
		}

		System.out.println(ans);

	}

}
