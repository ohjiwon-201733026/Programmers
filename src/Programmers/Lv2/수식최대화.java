package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 수식최대화 {

    @Test
    public void test(){
        Assertions.assertEquals(60420,solution("100-200*300-500+20"));
        Assertions.assertEquals(300,solution("50*6-3*2"));
    }

    private static int [][] op={{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};
    private static ArrayList<Long> num=new ArrayList<>();
    private static ArrayList<Integer> oper=new ArrayList<>();
    public long solution(String expression){

        long max=0L;
        for (int[] o : op) {
            store(expression);
            for(int i=0;i<o.length;++i){ // 0,1,2
                for(int j=0;j<oper.size();++j){ // 연산자 리스트 탐색
                    if(oper.get(j)==o[i]){
                        long n=calc(num.get(j),num.get(j+1),oper.get(j));
                        num.remove(j);
                        num.remove(j);
                        num.add(j,n);
                        oper.remove(j);
                        j--;
                    }

                }
            }
            max=Math.max(max,Math.abs(num.remove(0)));
        }

        return max;

    }

    private void store(String expression) {
        String tmp="";
        for(int i=0;i<expression.length();++i){
            char c=expression.charAt(i);
            if(c=='-' || c=='+' || c=='*'){
                int a=0;
                switch(c){
                    case '-' : a=0; break;
                    case '+' : a=1; break;
                    case '*' : a=2; break;
                }
                num.add(Long.parseLong(tmp));
                oper.add(a);
                tmp="";
            }
            else{
                tmp+=c;
            }
        }
        num.add(Long.parseLong(tmp));
    }

    public Long calc(long a, long b, int op){
        if(op==0) return a-b;
        if(op==1) return a+b;
        if(op==2) return a*b;

        return -1L;
    }
}
