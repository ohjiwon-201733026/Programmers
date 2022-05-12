package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B5582_공통부분문자열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x=sc.nextLine();
        String y=sc.nextLine();

        int [][] dp=new int [x.length()+1][y.length()+1];
        int answer=0;
        for(int i=1;i<=x.length();++i){
            for(int j=1;j<=y.length();++j){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    answer=Math.max(answer,dp[i][j]);
                }
            }
        }

        System.out.println(answer);



    }
}
