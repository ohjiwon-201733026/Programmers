package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 일10옮기기 {

    @Test
    public void test(){
        String [] answer=new String []{"1101","100110110","0110110111"};
        String [] result=solution(new String []{"1110","100111100","0111111010"});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }

    public String [] solution(String [] s) {
        String [] answer=new String[s.length];
        StringBuilder sb;
        for(int i=0;i<s.length;++i){
            String str=s[i];
            Stack<Character> stack=new Stack<>();
            int cnt=0;
            for(int j=0;j<str.length();++j){
                char z=str.charAt(j);
                if(stack.size()>=2){
                    char y=stack.pop();
                    char x=stack.pop();

                    if(x=='1' && y=='1' && z=='0') cnt++;
                    else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }else{
                    stack.push(z);
                }
            }

            int idx=stack.size();
            boolean flag=false;

            sb=new StringBuilder();
            while (!stack.isEmpty()){
                if(!flag && stack.peek()=='1') idx--;

                if(!flag && stack.peek()=='0') flag=true;

                sb.insert(0,stack.pop());
            }

            if(cnt>0){
                while(cnt>0){
                    sb.insert(idx,"110");
                    idx+=3;
                    cnt--;
                }
                answer[i]=sb.toString();
            }
            else{
                answer[i]=s[i];
            }
        }
        return answer;

    }
}
