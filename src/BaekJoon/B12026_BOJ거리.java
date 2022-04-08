package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B12026_BOJ거리 {

    static int n;
    static char [] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new char[n];
        String s=sc.next();

        for(int i=0;i<s.length();++i) arr[i]=s.charAt(i);
        long [] dp=new long [s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<s.length();++i){
            char c=arr[i];
            char t = 0;
            if(c=='B') t='J';
            if(c=='O') t='B';
            if(c=='J') t='O';
            for(int j=0;j<i;++j){
                if(arr[j]==t){
                    dp[i]=Math.min(dp[i],(i-j)*(i-j)+dp[j]);
                }
            }
        }

        System.out.println(dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1]);

    }
}
