// 문자열 압축
package Programmers.Kakao;

public class Kakao2020_1 {

	public static int compress(String s, int n) {
		StringBuilder result = new StringBuilder();
		String pattern = s.substring(0, n);
		int count = 1;
		for (int i = n; i <= s.length() - n; i += n) {
			if (s.substring(i, i + n).equals(pattern))
				++count;
			else {
				if (count > 1)
					result.append(count);
				result.append(pattern);
				pattern = s.substring(i, i + n);
				count = 1;
			}
		}
		if (count > 1)
			result.append(count);
		result.append(pattern);
		int tail = s.length() % n;
		if (tail > 0)
			result.append(s.substring(s.length() - tail));
		return result.toString().length();
	}

	public static int solution(String s) {
		int min=Integer.MAX_VALUE;

		for(int n=1;n<=s.length();n++) {
			if(min>compress(s,n)) min=compress(s,n);
		}


		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede",
				 "abcabcabcabcdededededede", "xababcdcdababcdcd", "ab", "aa", "a" };
				 for (String s : a)
				 System.out.println(solution(s));
	}

}
