package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B9935_문자열폭발 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String origin=sc.next();
        String remove=sc.next();

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<origin.length();++i){
            stack.push(origin.charAt(i));

            if(stack.size()>=remove.length()){
                boolean flag=true;
                for(int j=0;j<remove.length();++j){
                    if(stack.get(stack.size()-remove.length()+j)!=remove.charAt(j)){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    for(int j=0;j<remove.length();++j){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        System.out.println(sb.length()>0?sb.toString():"FRULA");
    }
}
