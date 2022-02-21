package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class 예상대진표 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(8,4,7));
    }

    public int solution(int N, int A, int B){
        int cnt=1;
        int left=0,right=0;
        if(A<B) {
            left=A;right=B;
        }
        else{
            left=B;right=A;
        }

        while (true){
            if(left%2!=0 && right-left==1) break;

            left=(left+1)/2;
            right=(right+1)/2;
            cnt++;
        }
        return cnt;
    }
}
