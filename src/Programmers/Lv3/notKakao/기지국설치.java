package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 기지국설치 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(11,new int []{4,11},1));
        Assertions.assertEquals(3,solution(16,new int []{9},2));
        Assertions.assertEquals(0,solution(10,new int []{5},5));
    }

    public int solution(int n, int [] stations, int w){
        int left=0,right=0,baseL=0,baseR=0,result=0;

        for(int i=0;i<stations.length;++i){
            int base=stations[i];
            left=baseR;

            baseL=base-w;
            baseR=base+w;

            if(baseL<0) baseL=0;
            if(baseR>n) baseR=n;

            right=baseL-1;
            if(right<0) continue;
            if(left==right) continue;
            if(left>right) continue;
            double temp=(double) (right-left)/((2*w)+1);
            if(temp%1==0) result+=(int) temp;
            else result+=(int) temp+1;
        }

        if(baseR!=n){
            double temp=(double) (n-baseR)/((2*w)+1);
            if(temp%1==0) result+=(int) temp;
            else result+=((int) temp)+1;
        }

        return result;
    }
}
