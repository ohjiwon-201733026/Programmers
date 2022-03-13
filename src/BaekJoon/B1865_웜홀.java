package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1865_웜홀 {
    static int N,M,W;
    static int [] dist;
    static ArrayList<Road> [] list;
    static final int INF=987654321;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (tc-->0){
            N = sc.nextInt();
            M = sc.nextInt();
            W = sc.nextInt();

            dist = new int[N + 1];
            list = new ArrayList[N+1];
            for (int i = 0; i <= N; ++i) {
                list[i]=new ArrayList<>();
            }

            for (int i = 0; i < M + W; ++i) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int weight = sc.nextInt();

                if (i < M) {
                    list[start].add(new Road(end, weight));
                    list[end].add(new Road(start, weight));
                } else {
                    list[start].add(new Road(end, -weight));
                }
            }

            boolean isMinusCycle = false;

            for (int i = 1; i <= N; ++i) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if (!isMinusCycle) {
                sb.append("NO\n");
            }
       }
        System.out.println(sb.toString());

    }

    public static boolean bellmanFord(int start){
        Arrays.fill(dist,INF);
        dist[start]=0;
        boolean update=false;

        for(int i=1;i<N;++i){
            update=false;

            for(int j=1;j<=N;++j){
                for (Road road : list[j]) {
                    if(dist[j]!=INF && dist[road.end]>dist[j]+road.weight){
                        dist[road.end] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }

            if(!update) break;
        }

        if(update){
            for(int i=1;i<=N;++i){
                for (Road road : list[i]) {
                    if (dist[i] != INF && dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Road implements Comparable<Road>{
        int end,weight;

        public Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight-o.weight;
        }
    }

}
