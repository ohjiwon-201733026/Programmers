package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 양과늑대 {

    @Test
    public void test(){
        Assertions.assertEquals(5,solution(new int []{0,0,1,1,1,0,1,0,1,0,1,1},new int [][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
    }

    static ArrayList<Integer> [] arr;
    static int ans=0;
    public int solution(int [] info, int [][] edges){
        arr=new ArrayList[info.length];
        for(int i=0;i<info.length;++i) arr[i]=new ArrayList<>();

        for (int[] edge : edges) {
            int parent=edge[0];
            int child=edge[1];
            arr[parent].add(child);
        }

        ArrayList<Integer> available=new ArrayList<>();
        available.add(0);

        dfs(0,0,0,available,info);

        return ans;
    }

    void dfs(int cur, int sheep, int wolf, ArrayList<Integer> available, int [] info){

        sheep+=info[cur]==0?1:0;
        wolf+=info[cur];
        if(wolf>=sheep) return;
        ans=Math.max(ans,sheep);

        ArrayList<Integer> newAvailable=new ArrayList<>();
        newAvailable.addAll(available);

        if(arr[cur]!=null) newAvailable.addAll(arr[cur]);
        newAvailable.remove(Integer.valueOf(cur));

        for (Integer next : newAvailable) {
            dfs(next,sheep,wolf,newAvailable,info);
        }
    }
}
