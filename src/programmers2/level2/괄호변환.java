package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class 괄호변환 {

    @Test
    public void test(){
        Assertions.assertEquals("(()())()",solution("(()())()"));
        Assertions.assertEquals("()",solution(")("));
        Assertions.assertEquals("()(())()",solution("()))((()"));
    }

    public String solution(String p){
        // 1
        if(p.length()==0) return p;

        // 2
        int idx=balancedString(p);
        String u=p.substring(0,idx+1);
        String v=p.substring(idx+1);
        // 3
        if(rightString(u)) {
            return u+solution(v);
        }
        else { // 4
            StringBuilder sb=new StringBuilder();
            // 4-1
            sb.append("(");

            // 4-2
            sb.append(solution(v));

            // 4-3
            sb.append(")");

            // 4-4
             return sb.append(removeAndReverse(u)).toString();
        }
    }

    public int balancedString(String p){
        int cnt=0;
        int i=0;
        for(i=0;i<p.length();++i){
            char c=p.charAt(i);

            if(c=='(') cnt++;
            else cnt--;
            if(cnt==0) return i;
        }
        return -1;
    }

    public boolean rightString(String p){
        int cnt=0;
        for(int i=0;i<p.length();++i){
            char c=p.charAt(i);
            if(c=='(') cnt++;
            else cnt--;
            if(cnt<0) return false;
        }

        if(cnt==0) return true;
        else return false;
    }

    public String removeAndReverse(String p){
        p=p.substring(1,p.length()-1);
        StringBuilder sb=new StringBuilder();

        for (char c : p.toCharArray()) {
            if(c=='(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }
}
