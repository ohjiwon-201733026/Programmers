package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;


public class 섬연결하기 {

    @Test
    public void test(){
        Assertions.assertEquals(4,solution(4
                ,new int [][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }
    int [] findParent;
    public int solution(int n,int [][] costs){
        Arrays.sort(costs,(a, b)->a[2]-b[2]);
        int answer=0;

        findParent=new int [n];
        for(int i=0;i<n;++i){
            findParent[i]=i;
        }

        for(int i=0;i<costs.length;++i){
            int firstIsland=find(costs[i][0]);
            int secondIsland=find(costs[i][1]);
            if(firstIsland!=secondIsland){ // 부모가 다르면 연결되지 않은 것
                findParent[secondIsland]=firstIsland;
                answer+=costs[i][2];
            }
        }

        return answer;

    }

    public int find(int child){
        if(findParent[child]==child){
            return child;
        }
        else{
            return findParent[child]=find(findParent[child]);
        }
    }
}
