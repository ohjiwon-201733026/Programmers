package BaekJoon;

import java.util.Scanner;

public class B2293_동전1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int [] coins=new int [n];
        for(int i=0;i<n;++i) coins[i]=sc.nextInt();

        int [] dp=new int [k+1];

        dp[0]=1;
        for(int i=0;i<coins.length;++i){
            int coin=coins[i];
            for(int j=0;j<=k;++j){
                if(j-coin>=0){
                    dp[j]+=dp[j-coin];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
