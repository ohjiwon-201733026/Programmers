package programmers2.level2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 짝지어제거하기 {

    @Test
    public void test(){
        Assertions.assertEquals(1,solution("baabaa"));
        Assertions.assertEquals(0,solution("cdcd"));
    }

    public int solution(String s){
        Stack<Character> stack=new Stack<>();

        for (char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if(stack.peek()==c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        return stack.isEmpty()?1:0;
    }
}
