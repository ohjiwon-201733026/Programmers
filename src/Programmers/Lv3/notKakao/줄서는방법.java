package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class 줄서는방법 {

    @Test
    public void test(){
        int [] arr=solution(3,5);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public int [] solution(int n, int k){
        ArrayList<Integer> arr=new ArrayList<>();
        int [] ans=new int [n];
        long fn=1;
        for(int i=1;i<=n;++i){
            arr.add(i);
            fn*=i;
        }
        k--;

        int idx=0;
        while(n>0){
            fn/=n;
            ans[idx++]=arr.get((int)(k/fn));
            arr.remove((int)(k/fn));
            k%=fn;
            n--;
        }
        return ans;
    }

}
