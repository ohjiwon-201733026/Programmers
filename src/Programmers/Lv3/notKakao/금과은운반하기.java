package Programmers.Lv3.notKakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 금과은운반하기 {
    @Test
    public void test(){
        Assertions.assertEquals(50,solution(10,10,new int[]{100},new int[]{100},new int[]{7},new int []{10}));
        Assertions.assertEquals(499,solution(90,500,new int[]{70,70,0},new int[]{0,0,500},new int[]{100,100,2},new int []{4,8,1}));
    }

    int n;
    public long solution(int a, int b, int [] g, int [] s, int [] w, int []t){
        n=w.length;

        long lo=0,hi=(long)1e15,mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(check(mid,a,b,t,w,g,s)) hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }

    private boolean check(long mid,int a, int b,int[] t,int [] w, int [] g, int[] s) {
        long total=0,gold=0,silver=0;
        for(int i=0;i<n;++i){
            long cnt=mid/(t[i]*2);
            if(mid>=cnt*(t[i]*2)+t[i]) cnt++;

            //최대 운반량, 최대 매장량
            long upper=Math.min(cnt*w[i],g[i]+s[i]);
            total+=upper;
            gold+=Math.min(g[i],upper);
            silver+=Math.min(s[i],upper);
            if(total>=a+b && gold>=a && silver>=b) return true;
        }
        return false;
    }
}
