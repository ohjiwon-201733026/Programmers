package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 징검다리건너기 {

    @Test
    public void test(){

        System.out.println(check(new int []{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},4,3));
        Assertions.assertEquals(3,solution(new int []{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }

    public int solution(int [] stones, int k){
        int min=0,max=0;
        for (int stone : stones) {
            max=Math.max(stone,max);
        }
        int answer=0;
        int left=min;
        int right=max;
        while(left<=right){
            int mid=(left+right)/2;

            if(check(stones,mid,k)){
                answer=Math.max(mid,answer);
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return answer;
    }

    public boolean check(int [] stones, int mid, int k){
        int fault=0;
        for(int i=0;i<stones.length;++i){
            int tmp=stones[i]-mid;
            if(tmp<0) fault++;
            else fault=0;

            if(fault==k) return false;
        }

        return true;
    }
}
