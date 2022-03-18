package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B9935_문자열폭발 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String pattern=sc.next();

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<str.length();++i){
            char c=str.charAt(i);
            stack.push(c);

            if(stack.size()>=pattern.length()){

                boolean isSame=true;
                for(int idx=0;idx<pattern.length();++idx){
                    char c1=stack.get(stack.size()-pattern.length()+idx);
                    char c2=pattern.charAt(idx);
                    if(c1!=c2) {
                        isSame=false;
                        break;
                    }
                }

                if(isSame){
                    for(int cnt=0;cnt<pattern.length();++cnt){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        System.out.println(sb.toString().length()==0?"FRULA":sb.toString());

    }
}
