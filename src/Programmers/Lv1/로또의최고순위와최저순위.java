package Programmers.Lv1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

public class 로또의최고순위와최저순위 {

    @Test
    public void test(){
        int [] lottos1={44, 1, 0, 0, 31, 25};
        int [] lottos2={0, 0, 0, 0, 0, 0};
        int [] lottos3={45, 4, 35, 20, 3, 9};

        int [] win_nums1={31, 10, 45, 1, 6, 19};
        int [] win_nums2={38, 19, 20, 40, 15, 25};
        int [] win_nums3={20, 9, 3, 45, 4, 35};

        int [] result=solution(lottos3,win_nums3);
        System.out.println(result[0]+" "+result[1]);
    }

    public int [] solution(int [] lottos, int [] win_nums){
        HashSet<Integer> win=new HashSet<>();

        for(int i:win_nums){ // win
            win.add(i);
        }
        int count=0;
        int zero=0;
        for(int i:lottos){
            if(win.contains(i)) count++;
            if(i==0) zero++;
        }

        int max=7-(count+zero);
        int min=7-count;

        if(max>=6) max=6;
        if(min>=6) min=6;

        return new int []{max,min};

    }
}
