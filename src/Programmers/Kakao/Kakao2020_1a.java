// 문자열 압축 복습
package Programmers.Kakao;

public class Kakao2020_1a {
	public static int compress(String s,int n) {
		StringBuilder answer=new StringBuilder();
		String pattern=s.substring(0,n);
		int count=1;

		for(int i=n;i<=s.length()-n;i+=n) {
			if(pattern.equals(s.substring(i,i+n))) ++count;
			else {
				if(count>1) answer.append(count);
				answer.append(pattern);
				pattern=s.substring(i,i+n);
				count=1;
			}
		}

		if(count>1) answer.append(count);
		answer.append(pattern);
		int tail=s.length()%n;
		if(tail>0) {
			answer.append(s.substring(s.length()-tail));
		}
		return answer.toString().length();
	}

	public static int solution(String s) {
		int answer=Integer.MAX_VALUE;

		for(int i=1;i<=s.length();i++) {
			if(answer>compress(s,i)) answer=compress(s,i);
		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede",
				 "abcabcabcabcdededededede", "xababcdcdababcdcd", "ab", "aa", "a" };
				 for (String s : a)
				 System.out.println(solution(s));
	}

}
