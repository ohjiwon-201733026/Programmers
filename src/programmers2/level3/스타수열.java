package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 스타수열 {

    @Test
    public void test(){
        Assertions.assertEquals(0,solution(new int []{0}));
        Assertions.assertEquals(4,solution(new int []{5,2,3,3,5,3}));
        Assertions.assertEquals(8,solution(new int []{0,3,3,0,7,2,0,2,2,0}));
        Assertions.assertEquals(6,solution(new int []{0, 0, 3, 1, 2, 1, 3, 4, 0, 1, 4}));
    }

    public int solution(int [] a){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i : a) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int max=0;
        int maxKey=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (Integer key : map.keySet()) {
            if(map.get(key)>max) {
                max=map.get(key);
            }
        }

        for (Integer key : map.keySet()) {
            if(map.get(key)==max) list.add(key);
        }
        int answer=0;
        for (Integer key : map.keySet()) {
            if(map.get(key)*2<=answer) continue;
            int cnt=0;
            boolean [] flag=new boolean[a.length];
            for(int i=0;i<a.length;++i){
                if(key==a[i]){
                    if(i-1>=0 && !flag[i-1]&&!flag[i] && a[i-1]!=a[i]) {
                        cnt+=2;
                        flag[i-1]=flag[i]=true;
                    }
                    else if(i+1<a.length && !flag[i+1] && !flag[i] && a[i]!=a[i+1]) {
                        cnt+=2;
                        flag[i]=flag[i+1]=true;
                        i++;
                    }
                }
            }
            answer=Math.max(answer,cnt);
        }


        return answer;
    }
}
