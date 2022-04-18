package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2553_사회망서비스 {

    static int n;
    static ArrayList<Integer> [] arr;
    static int [][] dp;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        arr=new ArrayList[n+1];
        dp=new int [n+1][2];
        visited=new boolean[n+1];
        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    public static void dfs(int number){
        visited[number]=true;
        dp[number][0]=0;
        dp[number][1]=1;

        for (Integer child : arr[number]) {
            if(!visited[child]){
                dfs(child);
                dp[number][0]+=dp[child][1];
                dp[number][1]+=Math.min(dp[child][0],dp[child][1]);
            }
        }
    }
}
