package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N진수게임 {

    @Test
    public void test(){
        Assertions.assertEquals("0111",solution(2,4,2,1));
        Assertions.assertEquals("02468ACE11111111",solution(16,16,2,1));
        Assertions.assertEquals("13579BDF01234567",solution(16,16,2,2));
    }

    public static String [] arr={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=t*m;++i){
            String s=toN(n,i);
            sb.append(s);
        }
        StringBuilder answer=new StringBuilder();
        String s=sb.toString();
        for(int i=0;i<t;++i){
            answer.append(s.charAt(i*m+p-1));
        }

        return answer.toString();
    }

    public String toN(int n, int i){
        StringBuilder sb=new StringBuilder();
        if(i==0) return "0";
        while (i!=0){
            String x=arr[i%n];
            i=i/n;

            sb.insert(0,x);
        }
        return sb.toString();
    }
}
