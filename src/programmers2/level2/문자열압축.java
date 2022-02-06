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
        int answer=s.length();
        StringBuilder sb = null;
        for(int length=1;length<s.length();++length){
            sb=new StringBuilder();
            String pattern=s.substring(0,length);
            int cnt=1;
            for(int i=length;i<=s.length()-length;i+=length){
                String tmp=s.substring(i,i+length);
                if(tmp.equals(pattern)){
                    cnt++;
                }else{
                    if(cnt>1) sb.append(cnt);
                    sb.append(pattern);
                    pattern=tmp;
                    cnt=1;
                }
            }
            if(cnt>1) sb.append(cnt);
            sb.append(pattern);
            int tail=s.length()%length;
            if(tail>0) sb.append(s.substring(s.length()-tail));
            answer= Math.min(answer,sb.toString().length());
        }

        return answer;

    }
}
