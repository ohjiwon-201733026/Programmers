package BaekJoon;

import java.util.Scanner;

public class B12865_평범한배낭 {
    static int [][] dp;
    static int [] W;
    static int [] V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        W=new int[N+1];
        V=new int [N+1];

        dp=new int [N+1][K+1];

        for(int i=1;i<=N;++i){
            W[i]=sc.nextInt();
            V[i]=sc.nextInt();
        }


        for(int i=1;i<=N;++i){
            for(int j=1;j<=K;++j){
                // i번째 무게를 더 담을 수 없는 경우
                if(W[i]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }


}
