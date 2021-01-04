package BaekJoon;

public class Review {

	private static boolean balanced(String s) {
		int count=0;
		for(char ch:s.toCharArray()) {
			count+=(ch=='(')?1:-1;
		}

		return count==0?true:false;
	}

	private static boolean wellFormed(String s) {
		int count=0;
		for(char ch:s.toCharArray()) {
			count+=(ch=='(')?1:-1;

			if(count<0) return false;
		}
		return count==0;
	}

	private static String solution(String s) {
		// TODO Auto-generated method stub
		if(s.length()==0) return s;
		int count=0;
		int i;
		for(i=0;i<s.length();i++) {
			count+=(s.charAt(i)=='(')?1:-1;
			if(count==0) break;
		}

		String u=s.substring(0,i+1);
		String v=s.substring(i+1);

		if(wellFormed(v)) return u+solution(v);
		String r=new StringBuilder('(')
				.append(solution(v))
				.append(')')
				.append(new StringBuilder(u).deleteCharAt(u.length()-1).deleteCharAt(0).toString()
						.replace('(','*').replace(')','(').replace('*',')')).toString();

		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "(()())()", ")(", "()", "()))((()", "()(())()", "))((" };
		 for (String s : a)
		 System.out.printf("%s => %s\n", s, solution(s));
	}



}
