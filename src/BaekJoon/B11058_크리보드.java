package BaekJoon;

import java.util.Scanner;

public class B11058_크리보드 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long [] dp=new long[n+1];

        for(int i=1;i<n+1;++i){
            dp[i]=dp[i-1]+1;
            if(i>6){
                for(int j=3;j<6;++j){
                    dp[i]=Math.max(dp[i],dp[i-j]*(j-1));
                }
            }
        }

        System.out.println(dp[n]);
    }
}
