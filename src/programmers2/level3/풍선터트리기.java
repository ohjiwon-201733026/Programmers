package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 풍선터트리기 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(new int []{9,-1,-5}));
        Assertions.assertEquals(6,solution(new int []{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }

    public int solution(int [] a){
        int [] left=new int [a.length];
        int [] right=new int [a.length];

        left[0]=a[0];
        for(int i=1;i<a.length;++i){
            if(a[i]<left[i-1]) left[i]=a[i];
            else left[i]=left[i-1];
        }

        right[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            if(a[i]<right[i+1]) right[i]=a[i];
            else right[i]=right[i+1];
        }

        int cnt=a.length;
        for(int i=1;i<a.length-1;++i){
            int num=a[i];
            if(left[i-1]<num && right[i+1]<num) cnt--;
        }

        return cnt;
    }
}
