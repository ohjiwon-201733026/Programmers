package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 큰수만들기 {

    @Test
    public void test(){
        Assertions.assertEquals("94",solution("1924",2));
        Assertions.assertEquals("3234",solution("1231234",3));
        Assertions.assertEquals("775841",solution("4177252841",4));
    }

    public String solution(String number, int k) {
        int K=k;
        Stack<Integer> stack=new Stack<>();

        stack.add(number.charAt(0)-'0');
        for(int i=1;i<number.length();++i){
            int c=number.charAt(i)-'0';

            while (k>0 && !stack.isEmpty() && stack.peek()<c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<number.length()-K;++i){
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
