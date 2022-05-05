package BaekJoon.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class B2098_외판원순회 {

    static int n;
    static int [][] map;
    static int [][] dp;
    static int fullBit;
    static final int INF=987654321;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        map=new int [n][n];
        fullBit=(1<<n)-1;

        dp=new int [n][fullBit];

        for(int i=0;i<n;++i){
            Arrays.fill(dp[i],INF);
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                map[i][j]=sc.nextInt();
            }
        }


        System.out.println(tsp(0,1));


    }

    static int tsp(int city, int check){

        if(check==fullBit){
            if(map[city][0]==0) return 987654321;
            else return map[city][0];
        }

        if(dp[city][check]!=INF) return dp[city][check];

        for(int i=0;i<n;++i){
            int next=(1<<i)|check;

            if(map[city][i]==0 || (check & (1<<i))!=0) continue;

            dp[city][check]=Math.min(dp[city][check],tsp(i,next)+map[city][i]);
        }

        return dp[city][check];




    }
}
