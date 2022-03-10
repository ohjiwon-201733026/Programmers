package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 섬연결하기 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    int [] parent;
    public int solution(int n, int [][] costs){

        Arrays.sort(costs,(c1,c2)->c1[2]-c2[2]);
        parent=new int [n];

        for(int i=0;i<n;++i){
            parent[i]=i;
        }

        int answer=0;
        for (int[] cost : costs) {
            int x=getParent(cost[0]);
            int y=getParent(cost[1]);
            int d=cost[2];

            if(x!=y) {
                union(cost[0],cost[1]);
                answer+=d;
            }

        }

        return answer;

    }

    public int getParent(int x){
        if(x==parent[x]) return x;

        return parent[x]=getParent(parent[x]);
    }

    public void union(int x, int y){
        x=getParent(x);
        y=getParent(y);

        if(x<y) parent[y]=x;
        else parent[x]=y;
    }




}
