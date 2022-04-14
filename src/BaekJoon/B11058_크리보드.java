package BaekJoon;

import java.util.Scanner;

public class B11058_크리보드 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        long [] dp=new long [n+1];
        if(n<=6) System.out.println(n);
        else{
            for(int i=0;i<=6;++i) dp[i]=i;
            for(int i=7;i<=n;++i){
                dp[i]=dp[i-1]+1;
                dp[i]=Math.max(dp[i-5]*4,Math.max(dp[i-3]*2,dp[i-4]*3));
            }

            System.out.println(dp[n]);
        }


    }
}
