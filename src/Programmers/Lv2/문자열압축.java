package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 문자열압축 {

    @Test
    public void test(){
        Assertions.assertEquals(7,solution("aabbaccc"));
        Assertions.assertEquals(9,solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8,solution("abcabcdede"));
        Assertions.assertEquals(14,solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17,solution("xababcdcdababcdcd"));
    }

    public int solution(String s){
        int answer=s.length();

        for(int i=1;i<=s.length();++i){
            int min=compress(s,i);
            System.out.println(min);
            answer=Math.min(answer,min);
        }

        return answer;
    }

    private int compress(String s, int n){
       StringBuilder result=new StringBuilder();
       String pattern=s.substring(0,n);
       int count=1;

       for(int i=n;i<=s.length()-n;i+=n){
           if(s.substring(i,i+n).equals(pattern)) count++;
           else{
               if(count>1) result.append(count);
               result.append(pattern);
               count=1;
               pattern=s.substring(i,i+n);
           }
       }

       if(count>1) result.append(count);
       result.append(pattern);
       int tail=s.length()%n;
        if(tail>0) result.append(s.substring(s.length()-tail));

       return result.toString().length();

    }

}
