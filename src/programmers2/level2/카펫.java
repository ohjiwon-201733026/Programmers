package programmers2.level2;

import org.junit.jupiter.api.Test;

public class 카펫 {

    @Test
    public void test(){
        int [] answer=solution(24,24);
        System.out.println(answer[0]+" "+answer[1]);
    }

    public int [] solution(int brown, int yellow){
        int i=1;
        for(i=1;i<=yellow;++i){
            int n=0;
            if(yellow%i==0){
                n=(yellow/i)*2;
                n+=i*2;
                n+=4;

                if(n==brown) break;
            }
        }
        int row=i+2;
        int column=(yellow/i)+2;
        return new int []{column,row};
    }
}
