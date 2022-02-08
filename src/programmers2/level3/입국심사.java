package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 입국심사 {

    @Test
    public void test(){
        Assertions.assertEquals(28,solution(6,new int []{7,10}));
    }

    public long solution(int n, int [] times){
        Arrays.sort(times);

        long left=1;
        long right=(long)times[times.length-1]*n;
        long answer=right;

        while(left<=right){
            long mid=(left+right)/2;
            long sum=0;
            for (int time : times) {
                sum+=mid/time;
            }

            if(sum<n){
                left=mid+1;
            }
            else{
                right=mid-1;
                answer=Math.min(mid,answer);
            }
        }

        return answer;
    }

}
