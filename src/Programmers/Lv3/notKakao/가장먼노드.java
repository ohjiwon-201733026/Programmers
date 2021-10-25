package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(6,
                new int [][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    final int INF=Integer.MAX_VALUE;
    boolean [] visit;
    int [] d;
    ArrayList<Integer>[] arr;
    public int solution(int n, int [][] vertex){
        visit=new boolean [n+1];
        d=new int [n+1];
        arr=new ArrayList [n+1];

        for(int i=1;i<=n;++i) {
            arr[i]=new ArrayList<>();
            d[i]=INF;
        }

        for (int[] v : vertex) {
            int a=v[0],b=v[1];
            arr[a].add(b);
            arr[b].add(a);
        }
        /**
         * 1
         * 2
         * 3 -6
         * 4
         * 5
         * 6 -3
         */

        dijkstra();
        int max=0;
        for (int i : d) if(max<i) max=i;
        int answer=0;
        for (int i : d) {
            if(i==max) answer++;
        }
        return answer;

    }

    public void dijkstra(){

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visit[1]=true;
        d[1]=0;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next:arr[cur]){
                if(!visit[next] && d[next]>d[cur]+1){
                    d[next]=d[cur]+1;
                    visit[next]=true;
                    q.add(next);
                }
            }
        }

    }
}
