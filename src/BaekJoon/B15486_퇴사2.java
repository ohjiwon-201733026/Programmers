package BaekJoon;

import java.util.Scanner;

public class B15486_퇴사2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] t=new int [n+2];
        int [] p=new int [n+2];
        int [] dp=new int [n+2];

        for(int i=1;i<=n;++i){
            t[i]=sc.nextInt();
            p[i]=sc.nextInt();
        }

        int answer=Integer.MIN_VALUE;
        for(int i=1;i<=n+1;++i){
            answer=Math.max(answer,dp[i]);
            int next=i+t[i];
            if(next<n+2){
                dp[next]=Math.max(dp[next],answer+p[i]);
            }
        }


        System.out.println(answer);


    }
}
