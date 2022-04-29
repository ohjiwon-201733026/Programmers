package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class B1167_트리의지름 {

    static int v;
    static ArrayList<int[]> [] arr;
    static boolean [] visited;
    static int [] dist;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();

        arr=new ArrayList[v+1];
        for(int i=0;i<=v;++i) arr[i]=new ArrayList<>();

        for(int i=1;i<=v;++i){
            int ver=sc.nextInt();
            while (true){
                int a=sc.nextInt();
                if(a==-1) break;
                int b=sc.nextInt();
                arr[ver].add(new int []{a,b});
            }
        }

        int [] start=dijkstra(1);

        int [] answer=dijkstra(start[0]);

        System.out.println(answer[1]);
    }

    public static int[] dijkstra(int start){
        PriorityQueue<int[]> q=new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        visited=new boolean[v+1];
        dist=new int [v+1];
        Arrays.fill(dist,987654321);
        q.add(new int []{start,0});
        dist[start]=0;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]]=true;

            for (int[] next : arr[cur[0]]) {
                if(!visited[next[0]] &&dist[next[0]] >dist[cur[0]]+next[1] ){
                    dist[next[0]] = dist[cur[0]]+next[1];
                    q.add(new int []{next[0],dist[next[0]]});
                }
            }
        }

        int max=0;
        int maxIdx=0;
        for(int i=1;i<=v;++i){
            if(max<dist[i]){
                max=dist[i];
                maxIdx=i;
            }
        }

        return new int []{maxIdx,max};
    }
}
