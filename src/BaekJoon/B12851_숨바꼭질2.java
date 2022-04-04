package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851_숨바꼭질2 {
    static int N,K;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        visited=new boolean[100001];

        if(K<=N){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }
        else{
            bfs(N);
            System.out.println(time);
            System.out.println(cnt);
        }
    }
    static int time=Integer.MAX_VALUE;
    static int cnt=0;
    public static void bfs(int start){
        Queue<int []> q=new LinkedList<>();
        q.add(new int []{start,0});
        visited[start]=true;

        while (!q.isEmpty()){
            int [] cur=q.poll();
            visited[cur[0]]=true;

            if(cur[0]==K){
                if(time>cur[1]) time=cur[1];
                if(time==cur[1]) cnt++;
            }

            for(int k=0;k<3;++k){
                int x=cur[0];
                if(k==0) x=x-1;
                if(k==1) x=x+1;
                if(k==2) x=2*x;
                if(0<=x && x<=100000 && !visited[x]){
                    q.add(new int []{x,cur[1]+1});
                }
            }
        }
    }
}
