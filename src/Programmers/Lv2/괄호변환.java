package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 괄호변환 {

    @Test
    public void test(){
        Assertions.assertEquals("(()())()",solution("(()())()"));
        Assertions.assertEquals("()",solution(")("));
        Assertions.assertEquals("()(())()",solution("()))((()"));
    }

    public String solution(String p){
        // 1.
        if(p.equals("")) return "";

        // 2.
        int bal=balancedIdx(p);
        String u=p.substring(0,bal+1);
        String v=p.substring(bal+1);
        // 3.
        if(isRight(u)) return u+solution(v);

        // 4.
        StringBuilder sb=new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        u=u.substring(1,u.length()-1);
        sb.append(reverse(u));

        return sb.toString();
    }

    private String reverse(String u) {

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<u.length();++i){
            char c=u.charAt(i);
            if(c=='(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    private boolean isRight(String u) {

        if(u.charAt(0)==')') return false;
        int cnt=0;
        for(int i=0;i<u.length();++i){
            char c= u.charAt(i);
            if(c=='(') cnt++;
            else cnt--;

            if(c<0) return false;
        }

        if(cnt==0) return true;
        else return false;
    }

    private int balancedIdx(String p) {
        int count=0;
        for(int i=0;i<p.length();++i){
            char c=p.charAt(i);
            if(c=='(') count++;
            else if(c==')') count--;

            if(count==0) return i;

        }

        return p.length();
    }

}
