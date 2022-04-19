package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2553_사회망서비스 {
    static int n;
    static int [][] dp;
    static ArrayList<Integer> [] arr;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dp=new int [n+1][2];
        arr=new ArrayList[n+1];
        visited=new boolean[n+1];

        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();

            arr[a].add(b);
            arr[b].add(a);
        }

        recur(1);

        System.out.println(Math.min(dp[1][0],dp[1][1]));

    }

    static void recur(int cur){
        dp[cur][0]=0;
        dp[cur][1]=1;
        visited[cur]=true;

        for (Integer child : arr[cur]) {
            if(!visited[child]){
                recur(child);
                dp[cur][0]+=dp[child][1];
                dp[cur][1]+=Math.min(dp[child][0],dp[child][1]);
            }
        }
    }
}
