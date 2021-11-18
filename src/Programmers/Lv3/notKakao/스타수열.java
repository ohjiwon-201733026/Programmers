package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 스타수열 {

    @Test
    public void test(){
        Assertions.assertEquals(0,solution(new int []{0}));
        Assertions.assertEquals(4,solution(new int []{5,2,3,3,5,3}));
        Assertions.assertEquals(8,solution(new int []{0,3,3,0,7,2,0,2,2,0}));
    }
    // 5 2 3 3 5 3
    // 5:2 3:3 2:1
    public int solution(int [] a){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>(a.length);
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            }
            else {
                map.replace(a[i], map.get(a[i]) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) * 2 <= answer) continue;
            int star = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if ((a[j] == key || a[j + 1] == key) && (a[j] != a[j + 1])) {
                    star += 2; j++;
                }
            }
            answer = Math.max(answer, star); // 스타 수열 최대값

             }

             return answer;
    }
}
