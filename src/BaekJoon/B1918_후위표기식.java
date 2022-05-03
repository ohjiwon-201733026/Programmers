package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class B1918_후위표기식 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Character> stack=new Stack<>();

        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<str.length();++i){
            char c=str.charAt(i);

            switch (c){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek())>=priority(c)){
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(': stack.push(c);break;
                case ')':
                    while (!stack.isEmpty() && stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:sb.append(c);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    public static int priority(char c){
        if(c=='(' || c==')') return 0;
        if(c=='+' || c=='-') return 1;
        if(c=='*' || c=='/') return 2;
        return -1;
    }
}
