package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 수식최대화 {

    @Test
    public void test(){
        Assertions.assertEquals(60420,solution("100-200*300-500+20"));
        Assertions.assertEquals(300,solution("50*6-3*2"));
    }
    int [][] order={{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
    public long solution(String expression){
        String [] oper={"-","+","*"};
        String [] num=expression.split("[-*+]");
        String [] op=expression.split("[0-9]{1,3}");
        long answer=0;
        for (int[] a : order) {
            ArrayList<Long> number=new ArrayList<>();
            ArrayList<String> operator=new ArrayList<>();
            for (String s : num) {
                number.add(Long.parseLong(s));
            }
            for (String s : op) {
                if(s.equals("")) continue;
                operator.add(s);
            }
            for (int i : a) {
                String o=oper[i];
                while(true){
                    int idx=operator.indexOf(o);
                    if(idx==-1) break;
                    Long n=calc(number.remove(idx),number.remove(idx),o);
                    operator.remove(idx);
                    number.add(idx,n);
                }
            }
            answer=Math.max(answer,Math.abs(number.get(0)));

        }

        return answer;
    }

    Long calc(Long a, Long b, String o){
        switch (o){
            case "+":return a+b;
            case "-":return a-b;
            case "*":return a*b;
        }

        return -1L;
    }
}
