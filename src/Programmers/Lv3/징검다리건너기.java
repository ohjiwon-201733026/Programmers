package Programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 징검다리건너기 {
    @Test
    public void test() {
        int [] stones={2,4,5,3,2,1,4,2,5,1};
        int k=3;
        Assertions.assertEquals(3,solution(stones,k));
    }

    private static int solution(int[] stones, int k) {
        int max=0;
        for (int stone : stones) {
            max=Math.max(max,stone);
        }

        int answer=binarySearch(max,stones,k);
        return answer;
    }

    private static int binarySearch(int max, int[] stones, int k) {
        int start=0;
        int end=max; //5
        int mid=0;
        int answer=0;
        while(start<=end){
            mid=(start+end)/2;
            if(!cross(mid,stones,k)){
                end=mid-1;
            }
            else{
                start=mid+1;
                answer=Math.max(answer,mid);
            }
        }

        return answer;

    }
    // 0, 2, 3, 0, 1, 0, 2, 0, 3, 0
    private static boolean cross(int mid, int[] stones, int k) {
        int count=0;
        for (int stone : stones) {
            if(stone-mid<0) count++;
            else count=0;

            if(count==k) return false;
        }
        return true;
    }
}
