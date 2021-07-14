package Programmers.Lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    public static void main(String[] args) {
        int n=6;
        int [][] vertex={{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        int answer=solution(n,vertex);
        System.out.println(answer);
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<edge.length;++i) list.add(new ArrayList<Integer>());

        int a,b;
        for(int [] node :edge){
            a=node[0];
            b=node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int [] count=new int [n+1];
        boolean [] visited=new boolean [n+1];
        for(int i=1;i<=n;++i) count[i]=Integer.MAX_VALUE;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[0]=visited[1]=true;
        count[1]=0;
        int now;
        while(!q.isEmpty()){
            now=q.poll();
            for(int v:list.get(now)){
                if(!visited[v] && count[v]>count[now]+1){
                    count[v]=count[now]+1;
                    visited[v]=true;
                    q.add(v);
                }
            }
        }

        int max=0;
        for(int cnt:count){
            System.out.println(cnt);
            if(max<cnt){
                max=cnt;
                answer=1;
            }
            else if(max==cnt) answer++;
        }
        return answer;
    }


}
