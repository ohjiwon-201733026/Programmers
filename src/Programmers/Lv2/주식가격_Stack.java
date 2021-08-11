package Programmers.Lv2;

import java.util.Stack;

public class 주식가격_Stack {
    public static void main(String[] args) {
        int [] prices={1,2,3,2,3};
        int [] answer=solution(prices);
        for(int n:answer){
            System.out.println(n);
        }
    }

    public static int [] solution(int [] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack=new Stack<>();
        int i=0;
        stack.add(i);
        for(i=1;i< prices.length;++i){

            while(!stack.isEmpty() && prices[i]< prices[stack.peek()]){
                int n=stack.pop();
                answer[n]=i-n;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int beginIdx=stack.pop();
            answer[beginIdx]=i-beginIdx-1;
        }

        return answer;
    }
}
