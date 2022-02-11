package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 스타수열 {

    @Test
    public void test(){
        Assertions.assertEquals(0,solution(new int []{0}));
        Assertions.assertEquals(4,solution(new int []{5,2,3,3,5,3}));
        Assertions.assertEquals(8,solution(new int []{0,3,3,0,7,2,0,2,2,0}));
        Assertions.assertEquals(6,solution(new int []{0, 0, 3, 1, 2, 1, 3, 4, 0, 1, 4}));
    }

    public int solution(int [] a){
        int answer=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i : a) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int maxCnt=0;
        int max=0;
        for (Integer key : map.keySet()) {
            if(map.get(key)>maxCnt){
                maxCnt=map.get(key);
                max=key;
            }
        }

        int cnt=0;
        for (Integer key : map.keySet()) {
            if(map.get(key)*2<=answer) continue;
            max=key;
            boolean [] visited=new boolean[a.length];
            cnt=0;
            for(int i=0;i<a.length;++i){
                if(a[i]==max){
                    if(i-1>=0 && !visited[i-1] && !visited[i] && a[i-1]!=a[i]){
                        visited[i-1]=true;
                        visited[i]=true;
                        cnt+=2;
                    }else if(i+1<a.length && !visited[i] && !visited[i+1] && a[i]!=a[i+1]){
                        visited[i]=true;
                        visited[i+1]=true;
                        cnt+=2;
                        i++;
                    }

                }
            }
            answer=Math.max(cnt,answer);

        }



        return answer;
    }
}
