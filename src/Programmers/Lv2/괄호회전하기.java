package Programmers.Lv2;

import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        String s="([{)}]";
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer=0;
        int n=s.length();

        for(int i=0;i<n;++i){

            if(check(s)) { System.out.println(s);answer++;}
            s=s.substring(1)+s.charAt(0);
        }
        return answer;
    }

    public static boolean check(String s){
       Stack<Character> stack=new Stack<>();
       if(s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']') return false;
       stack.push(s.charAt(0));

       for(int i=1;i<s.length();++i){
           char c=s.charAt(i);
           if(c=='(' || c=='{' || c=='[') stack.push(c);
           else{
               if(stack.isEmpty()) stack.push(c);
               if(c==')' && stack.peek()=='(') stack.pop();
               if(c=='}' && stack.peek()=='{') stack.pop();
               if(c==']' && stack.peek()=='[') stack.pop();
           }
       }
        return stack.isEmpty()?true:false;
    }
}
