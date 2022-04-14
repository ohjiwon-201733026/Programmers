package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1509_팰린드롬분할 {

    static int [] dp;
    static boolean [][] p;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        p=new boolean[s.length()+1][s.length()+1];
        dp=new int [s.length()+1];

        palindrome(s,s.length());
        for(int i=1;i<=s.length();++i) dp[i]=Integer.MAX_VALUE;

        for(int i=1;i<=s.length();++i){
            for(int j=1;j<=i;++j){
                if(p[j][i]){
                    dp[i]=Math.min(dp[i],dp[j-1]+1);
                }
            }
        }

        System.out.println(dp[s.length()]);
    }

    public static void palindrome(String str,int len){

        for(int start=1;start<=len;start++){
            for(int end=start;end<=len;++end){
                boolean flag=true;

                int s=start-1;
                int e=end-1;

                while (s<=e){
                    if(str.charAt(s++)!=str.charAt(e--)){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    p[start][end]=true;
                }
            }
        }
    }


}
