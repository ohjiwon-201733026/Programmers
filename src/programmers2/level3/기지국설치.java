package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 기지국설치 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(11,new int []{4,11},1));
        Assertions.assertEquals(3,solution(16,new int []{9},2));
    }

    public int solution(int N,int [] stations, int W){
        int left=0,right=0,baseL=0,baseR=0,result=0;

        for(int i=0;i<stations.length;++i){
            int base=stations[i];
            left=baseR;

            baseL=base-W;
            baseR=base+W;

            if(baseL<0) baseL=0;
            if(baseR>N) baseR=N;

            right=baseL-1;
            if(right<0) continue;
            if(left==right) continue;
            if(left>right) continue;

            double temp=(double) (right-left)/((2*W)+1);
            if(temp%1==0) result+=(int) temp;
            else result+=(int) temp+1;
        }

        if(baseR!=N){
            double temp=(double) (N-baseR)/((2*W)+1);
            if(temp%1==0) result+=(int) temp;
            else result+=((int) temp)+1;
        }
        return result;
    }
}
