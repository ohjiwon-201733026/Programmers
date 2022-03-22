package BaekJoon;

import java.util.Scanner;

public class B12865_평범한배낭 {

    static int [] W;
    static int [] V;
    static int [] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        W=new int [n+1];
        V=new int [n+1];

        dp=new int [k+1];

        for(int i=1;i<=n;++i){
            W[i]=sc.nextInt();
            V[i]=sc.nextInt();
        }

        for(int i=1;i<=n;++i){
            for(int j=0;j<=k;++j){
                if(j-W[i]>=0){
                    dp[j]=Math.max(dp[j],dp[j-W[i]]+V[i]);
                }
            }
        }

        for(int i=0;i<=k;++i){
            System.out.print(dp[i]+" ");
        }

        System.out.println(dp[k]);
    }

}
