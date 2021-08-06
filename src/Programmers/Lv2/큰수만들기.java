package Programmers.Lv2;

import java.util.Stack;

public class 큰수만들기 {

    public static void main(String[] args) {
        String number="1000";
        int k=1;
        System.out.println(solution(number,k));
    }

    public static String solution(String number ,int k){
        char [] tmp=number.toCharArray();
        int [] num=new int [tmp.length];

        for(int i=0;i< num.length;++i){
            num[i]=tmp[i]-'0';
        }
        int K=k;
        Stack<Integer> stack=new Stack<>();
        stack.push(num[0]);
        for(int i=1;i<num.length;++i){
            while(!stack.isEmpty() && K>0 && stack.peek()<num[i]){
                stack.pop();
                K--;
            }

            stack.push(num[i]);
        }

        StringBuilder sb=new StringBuilder();
        for(int j=0;j<num.length-k;++j){
            sb.append(stack.get(j));
        }
        return sb.toString();


    }
}
