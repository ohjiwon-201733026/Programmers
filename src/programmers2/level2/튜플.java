package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class 튜플 {

    @Test
    public void test(){
        Integer [][] result=new Integer [][]{{2, 1, 3, 4},{2, 1, 3, 4},{111, 20},{123},{3, 2, 4, 1}};
        String [] s={"{{2},{2,1},{2,1,3},{2,1,3,4}}","{{1,2,3},{2,1},{1,2,4,3},{2}}","{{20,111},{111}}","{{123}}","{{4,2,3},{3},{2,3,4,1},{2,3}}"};
        for(int i=0;i<result.length;++i){
            Integer [] answer=solution(s[i]);

            for(int j=0;j<answer.length;++j){
                Assertions.assertEquals(result[i][j],answer[j]);
            }
        }
    }

    public Integer [] solution(String s){
        ArrayList<int[]> list=new ArrayList<>();
        String [] arr=s.split("[{}]");
        for (String s1 : arr) {
            if(s1.equals(",") || s1.equals(" ") || s1.equals("")) continue;
            String [] spl=s1.split(",");
            int [] tmp=new int [spl.length];
            for(int i=0;i<spl.length;++i) tmp[i]=Integer.parseInt(spl[i]);
            list.add(tmp);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1.length-o2.length;
            }
        });

        ArrayList<Integer> answer=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for (int[] a : list) {
            for (int i : a) {
                if(set.contains(i)) continue;
                else {
                    answer.add(i);
                    set.add(i);
                    break;
                }
            }
        }

        return answer.toArray(new Integer [answer.size()]);
    }
}
