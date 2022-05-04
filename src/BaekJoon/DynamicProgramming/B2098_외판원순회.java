package BaekJoon.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class B2098_외판원순회 {

   static int n, statusFullBit,INF=987654321;
   static int [][] w;
   static int [][] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        statusFullBit=(1<<n)-1;
        w=new int [n][n];
        dp=new int [n][statusFullBit];

        for(int i=0;i<n;++i){
            Arrays.fill(dp[i],INF);
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                w[i][j]=sc.nextInt();
            }
        }

        System.out.println(tsp(0,1)); // 0번 도시부터 탐색 시작 (check : 0001)
    }

    static int tsp(int x, int check){
        if(check==statusFullBit){ // 모든 도시 방문 완료
            if(w[x][0]==0) return INF; // 경로 없으면 탐색 무효화
            else return w[x][0]; // 경로가 존재하면 w[x][0]
        }
        // 메모제이션
        if(dp[x][check]!=INF) return dp[x][check];

        for(int i=0;i<n;++i){
            int next=check | (1<<i); // i 도시 방문
            // 경로가 없거나 i 도시를 이미 방문했을 경우 continue
            if(w[x][i]==0 || (check &(1<<i))!=0) continue;

            dp[x][check]=Math.min(dp[x][check],tsp(i,next)+w[x][i]);
        }

        return dp[x][check];
    }
}
