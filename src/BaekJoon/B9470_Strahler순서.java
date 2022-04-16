package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9470_Strahler순서 {
    static int m;
    static ArrayList<Integer> [] arr;
    static int [][] d;
    static int [] indegree;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0){
            int k=sc.nextInt();
            m=sc.nextInt();
            int p=sc.nextInt();

            arr=new ArrayList[m+1];
            d=new int [m+1][2];
            indegree=new int [m+1];

            for(int i=0;i<=m;++i) arr[i]=new ArrayList<>();

            while (p-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr[a].add(b);
                indegree[b]++;
            }

            unionFind();

            int ans=0;
            for(int i=1;i<=m;++i){
                ans=Math.max(ans,d[i][0]);
            }
            System.out.println(k+" "+ans);

        }
    }

    public static void unionFind(){
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=m;++i){
            if(indegree[i]==0) {
                q.add(i);
                d[i][0]=1;
            }
        }

        while (!q.isEmpty()){
            int num=q.poll();

            for (Integer next : arr[num]) {
                if(d[next][0]==d[num][0]){
                    d[next][1]++;
                }

                if(d[next][0]<d[num][0]){
                    d[next][0]=d[num][0];
                    d[next][1]=1;
                }

                indegree[next]--;
                if(indegree[next]==0){
                    if(d[next][1]>=2) d[next][0]++;
                    q.add(next);
                }

            }
        }
    }


}
