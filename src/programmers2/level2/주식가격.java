package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 주식가격 {

    @Test
    public void test(){
        int [] answer={4,3,1,1,0};
        int [] result=solution(new int []{1, 2, 3, 2, 3});

        for(int i=0;i<answer.length;++i)
            Assertions.assertEquals(answer[i],result[i]);
    }

    public int [] solution(int [] prices){
        int [] answer=new int [prices.length];
        Stack<Point> stack=new Stack<Point>();

        for(int i=0;i<prices.length;++i){
            if(stack.isEmpty()) stack.add(new Point(i,prices[i]));
            else{

                while (!stack.isEmpty() && stack.peek().price>prices[i]){
                    answer[stack.peek().idx]=i- stack.peek().idx;
                    stack.pop();
                }

                stack.add(new Point(i,prices[i]));

            }
        }
        int n=prices.length-1;
        while (!stack.isEmpty()){
            Point p=stack.pop();
            answer[p.idx]=n-p.idx;
        }

        return answer;
    }

    class Point{
        int idx;
        int price;

        public Point(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }
}
