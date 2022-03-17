package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class B2407_조합 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        BigInteger [][] dp=new BigInteger[101][101];

        for(int i=1;i<=n;++i){
            for(int j=0;j<=i;++j){
                if(j==0 || i==j) dp[i][j]=BigInteger.ONE;
                else dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
            }
        }

        System.out.println(dp[n][m]);

    }
}
