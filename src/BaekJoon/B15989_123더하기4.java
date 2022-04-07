package BaekJoon;

import java.util.Scanner;

public class B15989_123더하기4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        int [] dp=new int [10001];
        dp[0]=1;
        for(int i=1;i<=3;++i){
            for(int j=1;j<=10000;++j){
                if(j-i>=0) dp[j]+=dp[j-i];
            }
        }
        StringBuilder sb=new StringBuilder();
        while (t-->0){
            int x=sc.nextInt();
            sb.append(dp[x]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
