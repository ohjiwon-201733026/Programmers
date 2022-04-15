package BaekJoon;

import java.util.Scanner;

public class B10422_괄호 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        long [] dp=new long [5001];

        dp[0]=dp[2]=1;

        for(int i=3;i<=5000;++i){
            for(int j=2;j<=i;++j){
                dp[i]+=(dp[j-2]*dp[i-j])%1000000007;
            }
            dp[i]%=1000000007;
        }

        while (t-->0){
            int n=sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
