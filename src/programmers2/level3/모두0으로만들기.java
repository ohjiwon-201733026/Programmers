package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 모두0으로만들기 {

    @Test
    public void test(){
        Assertions.assertEquals(9,solution(new int []{-5,0,2,1,2},new int [][]{{0,1},{3,4},{2,3},{0,3}}));
    }

    ArrayList<Integer>[] list;
    boolean [] visited;
    int [] indegree;
    long [] long_a;
    long result;

    public long solution(int [] a,int [][] edges){
        long_a=new long[a.length];
        list=new ArrayList[a.length];
        long sum=0;
        for(int i=0;i<a.length;++i){
            sum+=a[i];
            long_a[i]=a[i];
            list[i]=new ArrayList<>();
        }

        if(sum!=0) return -1;
        indegree=new int [a.length];
        for(int i=0;i<edges.length;++i){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }

        visited=new boolean[a.length];
        topology();
        return result;
    }

    public void topology(){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i< indegree.length;++i){
            if(indegree[i]==1) q.offer(i);
        }

        while(!q.isEmpty()){
            int current=q.poll();
            visited[current]=true;
            for(int i=0;i<list[current].size();++i){
                int next=list[current].get(i);
                if(!visited[next]){
                    indegree[next]--;
                    long_a[next]+=long_a[current];
                    result+=Math.abs(long_a[current]);
                    long_a[current]=0;
                    if(indegree[next]==1) q.offer(next);
                }
            }
        }
    }
}
