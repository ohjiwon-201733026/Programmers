package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 일24나라의숫자 {

    @Test
    public void test(){
        Assertions.assertEquals("1",solution(1));
        Assertions.assertEquals("2",solution(2));
        Assertions.assertEquals("4",solution(3));
        Assertions.assertEquals("11",solution(4));
    }

    public String solution(int n){

        String [] num={"4","1","2"};
        String answer="";

        while (n>0){
            answer=num[n%3]+answer;
            n=(n-1)/3;
        }

        return answer;
    }
}
