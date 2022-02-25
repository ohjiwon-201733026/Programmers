package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 괄호회전하기 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution("[](){}"));
        Assertions.assertEquals(2,solution("}]()[{"));
        Assertions.assertEquals(0,solution("[)(]"));
        Assertions.assertEquals(0,solution("}}}"));

    }

    public int solution(String s){
        int answer=0;
        int n=s.length();
        while (n-->0){
            if(check(s)) answer++;
            s=s.substring(1)+s.substring(0,1);
        }

        return answer;

    }

    public boolean check(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                if(c==')') {
                    if(stack.peek()=='(') stack.pop();
                    else return false;
                }
                else if(c==']'){
                    if(stack.peek()=='[') stack.pop();
                    else return false;
                }
                else if(c=='}'){
                    if(stack.peek()=='{') stack.pop();
                    else return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        return false;

    }

}
