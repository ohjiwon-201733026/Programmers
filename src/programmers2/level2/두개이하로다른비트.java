package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 두개이하로다른비트 {

    @Test
    public void test(){
        int [] answer={3,11};
        long [] numbers={2,7};
        Long [] result=solution(numbers);
        Assertions.assertEquals(answer[0],result[0]);
        Assertions.assertEquals(answer[1],result[1]);
    }

    public Long [] solution(long [] numbers){
        Long [] answer=new Long [numbers.length];
        for (int i=0;i<numbers.length;++i) {
            long number=numbers[i];
            String s=toBinary(number);
            if(number%2==0){
                s=s.substring(0,s.length()-1)+"1";
            }
            else {
                s="0"+s;
                int idx=s.lastIndexOf("0");
                s=s.substring(0,idx)+"10"+s.substring(idx+2);
            }

            answer[i]=Long.parseLong(s,2);

        }
        return answer;
    }

    public String toBinary(long num){
        if(num==0) return "0";
        StringBuilder sb=new StringBuilder();
        while (num!=1){
            long m=num%2;
            num/=2;
            sb.append(m);
        }
        sb.append(1);
        return sb.reverse().toString();
    }
}
