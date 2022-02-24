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

    public String solution(String number, int k){
        int K=k;
        Stack<Integer> stack=new Stack<>();
        stack.push(number.charAt(0)-'0');
        for(int i=1;i<number.length();++i){
            int n=number.charAt(i)-'0';
            while (k>0 && !stack.isEmpty() && stack.peek()<n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j< number.length()-K;++j){
            sb.append(stack.get(j));
        }
        return sb.toString();
    }
}
