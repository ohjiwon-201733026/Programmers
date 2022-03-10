package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 올바른괄호 {

    @Test
    public void test(){
        Assertions.assertEquals(true,solution("()()"));
        Assertions.assertEquals(true,solution("(())()"));
        Assertions.assertEquals(false,solution(")()("));
        Assertions.assertEquals(false,solution("(()("));
    }

    public boolean solution(String s){
        int n=0;
        boolean flag=false;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(') n++;
            else n--;

            if(n<0) {
                flag=true;
            }
        }

        if(flag) return false;

        if(n!=0) return false;

        return true;
    }
}
