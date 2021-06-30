package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 수식최대화 {

    static Long [] n;
    static ArrayList<Character> oper;
    static int[][] operPr = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
    static Map<Character, Integer> map; // 연산자와 인덱스를 연결시켜줄 맵

    public static void  main(String[] args) {
        String s="100-200*300-500+20";
        long ans=solution(s);
        System.out.println(ans);
    }

    public static long solution(String expression) {
        long answer = 0;
        oper=new ArrayList<>();
        map=new HashMap<>();
        map.put('-',0);
        map.put('+',1);
        map.put('*',2);

        String [] nums=expression.split("[0-9]{1,3}");
        String [] operTmp=expression.split("[^0-9]");
        for(int i=0;i<operTmp.length;++i) oper.add(operTmp[i].charAt(0));
        n=new Long[nums.length];
        for(int i=0;i<nums.length;++i) n[i]=Long.parseLong(nums[i]);


        for(int i=0;i<operPr.length;++i){
            long result=Math.abs(getValue(operPr[i]));
            answer=Math.max(answer,result);
        }


        return answer;
    }
    private static long getValue(int [] ops){
        ArrayList<Long> number=new ArrayList<>();
        ArrayList<Character> opers=new ArrayList<>();

        for(Character op:oper) opers.add(op);
        for(Long num:n) number.add(num);

        for(int i=2;i>-1;--i){
            for(int j=0;j<opers.size();j++){
                if(ops[map.get(opers.get(j))]==i){
                    long a=number.remove(j);
                    long b=number.remove(j);
                    long result=doOperation(opers.get(j),a,b);
                    number.add(j,result);
                    opers.remove(j);
                    j--;
                }
            }
        }
        return number.remove(0);
    }

    private static long doOperation(char op,long a, long b){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
        }
        return 0;
    }
}
