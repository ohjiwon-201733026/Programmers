package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.regex.Matcher;

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
      int n=s.length();
      int answer=n;

      for(int len=1;len<s.length();++len){
          String pattern=s.substring(0,len);
          int hit=1;
          StringBuilder sb=new StringBuilder();

          for(int i=len;i<=n-len;i+=len){
              String tmp=s.substring(i,i+len);
              if(pattern.equals(tmp)) hit++;
              else{
                  if(hit>1){
                        sb.append(hit);
                  }
                  sb.append(pattern);
                  hit=1;
                  pattern=tmp;
              }
          }
          if(hit>1) sb.append(hit);
          sb.append(pattern);
          int tail=n%len;
          if(tail>0) sb.append(s.substring(n-tail));

          answer=Math.min(sb.toString().length(),answer);
      }



      return answer;

    }
}
