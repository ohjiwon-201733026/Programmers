package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class 입국심사 {

    @Test
    public void test(){
        Assertions.assertEquals(28,solution(6,new int []{7,10}));
    }

    public long solution(int n, int [] times){
        Arrays.sort(times);

        long left=0;
        long right=(long)n*times[times.length-1];
        long answer=right;


        while(left<=right){
            long mid=(left+right)/2;
            long sum=0;
            for(int i=0;i<times.length;++i){
                sum+=mid/times[i];
            }

            if(sum<n) left=mid+1;
            else{
                right=mid-1;
                answer=Math.min(answer,mid);
            }
        }
        return answer;
    }
}
