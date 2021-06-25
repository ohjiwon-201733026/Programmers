package study.week7;
import java.util.*;
public class 올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack=new Stack<>();

        if(s.charAt(0)==')') return false;
        else stack.push('(');

        for(int i=1;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(') stack.push('(');
            else{
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }

        if(stack.size()!=0) return false;



        return answer;
    }
}
