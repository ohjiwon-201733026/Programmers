package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Locale;

public class JadenCase문자열만들기 {

    @Test
    public void test(){
        Assertions.assertEquals("3people Unfollowed Me",solution("3people unFollowed me"));
        Assertions.assertEquals("For The Last Week",solution("for the last week"));
    }

    public String solution(String s){
        s=s.toLowerCase();

        boolean flag=true;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==' ') {
                flag = true;
                str.append(s.charAt(i));
            }
            else if(flag) { // 앞이 공백
                str.append((""+s.charAt(i)).toUpperCase());
                flag=false;
            }
            else{
                str.append(s.charAt(i));

            }
        }

        return str.toString();
    }
}
