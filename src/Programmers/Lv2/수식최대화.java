package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 수식최대화 {


    public static void  main(String[] args) {
        String s="100-200*300-500+20";
        long ans=solution(s);
        System.out.println(ans);
    }
    // 1: +, 2 :- , 3: *
    public static int [][] oprPr={{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
    public static HashMap<Integer,Character> map=new HashMap<>();
    public static long solution(String expression) {
        map.put(1,'+');
        map.put(2,'-');
        map.put(3,'*');
        long answer=0;

//        String [] num=expression.split("[0-9]{1,3}");
//        String [] opr=expression.split("[^0-9]");
//        for(String s:num) System.out.println(":"+s);

        String [] nums=expression.split("[0-9]{1,3}");
        String [] operTmp=expression.split("[^0-9]");
//        for(int i=0;i<operTmp.length;++i) oper.add(operTmp[i].charAt(0));
//        n=new Long[nums.length];
//        for(int i=0;i<nums.length;++i) n[i]=Long.parseLong(nums[i]);
//
//        long answer=0;
//        for(int i=0;i<oprPr.length;++i){
//            answer=Math.max(answer,calc(oprPr[i],num,opr));
//        }

        return answer;

    }

    public static long calc(int [] oprPr, String [] num, String [] opr){
        long ans=0;
        ArrayList<Long> n=new ArrayList<>();
        ArrayList<Character> o=new ArrayList<>();

        for(String a:num) n.add(Long.parseLong(a));
        for(String a:opr) o.add(a.charAt(0));

        for(int i=0;i< oprPr.length;++i){
            char operator=map.get(oprPr[i]);
            for(int j=0;j<opr.length;++j){
                if(o.get(j)==operator){
                    long a=n.remove(j);
                    long b=n.remove(j+1);
                    n.add(j,getVal(a,b,operator));
                    o.remove(j);
                }
            }
        }

        return n.get(0);

    }

    private static Long getVal(long a, long b, char operator) {
        long num=0;
        switch (operator){
            case '+': num= a+b; break;
            case '-': num= a-b; break;
            case '*': num= a*b; break;
        }

        return num;
    }
}
