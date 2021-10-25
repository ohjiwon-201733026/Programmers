package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        int answer=solution(s);
        System.out.println(answer);

    }

    private static int solution(String s) {

        Stack<String> stack=new Stack<>();

        if(s.charAt(0)=='}' || s.charAt(0)==')' ) return 0;
        int answer=0;
        for(int i=0;i<s.length();++i){
            String c=s.charAt(i)+"";
            if(c.equals(")")){ // ) 가 나오면
                if(stack.isEmpty()) return 0; // )만 나오면 올바르지 않음
                if(stack.peek().equals("(")){  // 바로 () 인 경우 -> 2 넣기
                    stack.pop();
                    stack.push("2");
                }else{ // ) 말고
                    int num=0;
                    while(true){
                        if(stack.isEmpty()) return 0;
                        if(stack.peek().equals("(")) break;
                        if(isVal(stack.peek())) return 0; // 중간에 [ 있는 경우
                        num+=Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(2*num+"");
                }
            }
            else if(c.equals("]")){
                if(stack.isEmpty()) return 0;
                if(stack.peek().equals("[")){ // []
                    stack.pop();
                    stack.push("3");
                }
                else{
                    int num=0;
                    while(true){
                        if(stack.isEmpty()) return 0;
                        if(stack.peek().equals("[")) break;
                        if(isVal(stack.peek())) return 0;
                        num+=Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(3*num+"");
                }
            }
            else{
                stack.push(c);
            }

        }
        int a=0;
        while(!stack.isEmpty()){
            if(isVal(stack.peek())) return 0;
            a+=Integer.parseInt(stack.pop());
        }
        return a;
    }

    private static boolean isVal(String peek) {
        char c=peek.charAt(0);
        if('0'<=c && c<='9') return false;
        else return true;
    }
}
