package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();


        System.out.println(solution(s));
    }

    public static int solution(String s){
        if(!rightCheck(s)) return 0;

        Stack<String> stack=new Stack<>();
        stack.push(s.charAt(0)+"");
        for(int i=1;i<s.length();++i){
            String c=s.charAt(i)+"";

            if(c.equals("(") || c.equals("[")) stack.push(c);
            else if(c.equals(")")){
                if(stack.peek().equals("(")){
                    stack.pop();
                    stack.push("2");
                }
                else{
                    int sum=0;
                    while (true){
                        if(stack.isEmpty()) return 0;
                        if(stack.peek().equals("(")) break;
                        sum+=Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(String.valueOf(2*sum));
                }
            }
            else if(c.equals("]")){
                if(stack.peek().equals("[")){
                    stack.pop();
                    stack.push("3");
                }
                else{
                    int sum=0;
                    while (true){
                        if(stack.isEmpty()) return 0;
                        if(stack.peek().equals("[")) break;
                        sum+=Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(String.valueOf(3*sum));
                }
            }

        }

        int answer=0;
        while (!stack.isEmpty()){
            answer+=Integer.parseInt(stack.pop());
        }

        return answer;
    }

    public static boolean rightCheck(String s){

        if(s.charAt(0)==')' || s.charAt(0)==']') return false;

        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));

        for(int i=1;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(' || c=='[') stack.push(c);
            else if(c==')'){
                if(stack.isEmpty()) return false;
                if(stack.peek()=='(') stack.pop();
                else return false;
            }
            else if(c==']'){
                if(stack.isEmpty()) return false;
                if(stack.peek()=='[') stack.pop();
                else return false;
            }
        }

        if(!stack.isEmpty()) return false;

        return true;


    }
}
