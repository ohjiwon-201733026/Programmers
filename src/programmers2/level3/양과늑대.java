package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 양과늑대 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(new int []{0,0,1,1,1,0,1,0,1,0,1,1},new int [][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
    }
    static ArrayList<Integer> [] childs;
    static int max=0;
    static int solution(int [] info, int [][] edges){
        childs=new ArrayList[info.length];
        for (int[] edge : edges) {
            int parent=edge[0];
            int child=edge[1];
            if(childs[parent]==null) childs[parent]=new ArrayList<>();
            childs[parent].add(child);
        }

        ArrayList<Integer> available=new ArrayList<>();
        available.add(0);
        dfs(0,0,0,available,info);

        return max;
    }

    static void  dfs(int sheepNum, int wolfNum,int cur,ArrayList<Integer> available, int [] info){
        sheepNum+=info[cur]^1;
        wolfNum+=info[cur];

        max=Math.max(sheepNum,max);

        if(sheepNum<=wolfNum) return;

        ArrayList<Integer> copyAvailable=new ArrayList<>();
        copyAvailable.addAll(available);

        if(childs[cur]!=null) copyAvailable.addAll(childs[cur]);
        copyAvailable.remove(Integer.valueOf(cur));

        for (Integer next : copyAvailable) {
            dfs(sheepNum,wolfNum,next,copyAvailable,info);
        }
    }
}
