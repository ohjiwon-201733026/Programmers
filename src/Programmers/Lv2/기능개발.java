package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Stack;

public class 기능개발 {

    public static void main(String[] args) {
        int [] progresses={95, 90, 99, 99, 80, 99};
        int [] speeds={1, 1, 1, 1, 1, 1};

        int [] answer=solution(progresses,speeds);
        for(int n:answer) System.out.println(n);

    }

    private static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer=new ArrayList<>();
        int [] day=new int [progresses.length];

        for(int i=0;i< progresses.length;++i){
            day[i]=(int)(Math.ceil((double) (100-progresses[i])/speeds[i]));
        }

       Stack<Integer> stack=new Stack<>();
        stack.add(day[0]);
        int cnt=1;
        for(int i=1;i<day.length;++i){
            if(stack.peek() >= day[i]) cnt++;
            else {
                answer.add(cnt);
                stack.pop();
                cnt=1;
                stack.push(day[i]);
            }
        }
        answer.add(cnt);

        int [] ans=new int[answer.size()];

        for(int i=0;i< answer.size();++i) ans[i]=answer.get(i);


        return ans;

    }
}
