package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1949_우수마을 {
    static int n;
    static boolean [] visited;
    static ArrayList<Integer> [] arr;
    static int [][] dp;
    static int [] cost;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        visited=new boolean[n+1];
        arr=new ArrayList[n+1];
        dp=new int [n+1][2];
        cost=new int [n+1];

        for(int i=1;i<=n;++i) cost[i]=sc.nextInt();
        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        recur(1);

        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }

    static void recur(int cur){
        visited[cur]=true;
        dp[cur][0]=0;
        dp[cur][1]=cost[cur];

        for (int child : arr[cur]) {
            if(!visited[child]){
                recur(child);
                dp[cur][0]+=Math.max(dp[child][0],dp[child][1]);
                dp[cur][1]+=dp[child][0];
            }
        }
    }
}
