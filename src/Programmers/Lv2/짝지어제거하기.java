package Programmers.Lv2;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek()==c) stack.pop();
            else stack.push(c);

        }
        if(stack.size()==0) answer=1;

        return answer;
    }
}
