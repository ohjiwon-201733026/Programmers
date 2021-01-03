//괄호 변환
package Programmers.Kakao;

public class Kakao2020_2 {

//	public static boolean wellFormed(String v) {
//		Stack<Character> stack=new Stack<>();
//		if(v.charAt(0)==')') return false;
//		stack.push(v.charAt(0));
//		for(int k=1;k<v.length();k++) {
//			if(stack.size()==0) continue;
//			if(stack.peek()==v.charAt(k)) stack.push(v.charAt(k));
//			else stack.pop();
//		}
//
//		return stack.size()==0?true:false;
//
//	}

	static boolean wellFormed(String s) {
		 int count = 0;
		 for (char c : s.toCharArray()) {
		 count += (c == '(') ? 1 : -1;
		 if (count < 0) return false;
		 }
		 return count == 0;
		 }


	public static String solution(String s) {
        if (s.length()==0) return s;
        int count=0;
        int i;
        for(i=0;i<s.length();i++) {
        	count+=(s.charAt(i)=='(')?1:-1;
        	if(count==0) break;
        }

        String u=s.substring(0,i+1);
        String v=s.substring(i+1);

        if(wellFormed(u)) return u+solution(v);
        var r=new StringBuilder("(")
        		.append(solution(v))
        		.append(")")
        		.append(new StringBuilder(u).deleteCharAt(u.length()-1).deleteCharAt(0).toString()
        		.replace('(','*').replace(')','(').replace('*',')'));
        return r.toString();


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "(()())()", ")(", "()", "()))((()", "()(())()", "))((" };
		 for (String s : a)
		 System.out.printf("%s => %s\n", s, solution(s));

	}

}
