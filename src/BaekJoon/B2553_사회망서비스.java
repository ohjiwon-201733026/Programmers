package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2553_사회망서비스 {

    static int n;
    static boolean [] visited;
    static List<Integer>[] grah;

    static int [][] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dp=new int [n+1][2];
        visited=new boolean[n+1];
        grah=new ArrayList[n+1];
        for(int i=1;i<=n;++i) grah[i]=new ArrayList<>();

        for(int i=1;i<n;++i){
            int start=sc.nextInt();
            int end=sc.nextInt();
            grah[start].add(end);
            grah[end].add(start);
        }

        dfs(1); // 트리구조이기 때문에 1부터 시작
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    static void dfs(int number){
        visited[number]=true;
        dp[number][0]=0; // 얼리어답터가 아닌 경우
        dp[number][1]=1; // 얼리어답터인 경우

        for (int child : grah[number]) {
            if(!visited[child]){
                dfs(child);
                dp[number][0]+=dp[child][1];
                dp[number][1]+=Math.min(dp[child][0],dp[child][1]);
            }
        }
    }
}
