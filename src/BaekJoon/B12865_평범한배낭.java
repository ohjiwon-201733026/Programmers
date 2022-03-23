package BaekJoon;


import java.util.Scanner;

public class B12865_평범한배낭 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int [] W=new int [n+1];
        int [] V=new int [n+1];

        for(int i=1;i<=n;++i){
            W[i]=sc.nextInt();
            V[i]=sc.nextInt();
        }

        int [][] dp=new int [n+1][k+1];

        for(int i=1;i<=n;++i){
            for(int j=0;j<=k;++j){
                if(j-W[i]<0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
            }
        }

        System.out.println(dp[n][k]);

    }

}
