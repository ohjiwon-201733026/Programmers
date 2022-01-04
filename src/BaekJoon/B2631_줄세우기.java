package BaekJoon;

import java.util.Scanner;

public class B2631_줄세우기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int [N];
        int [] dp=new int [N];

        for(int i=0;i<N;++i){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<N;++i){
            int max=0;
            for(int j=0;j<i;++j){
                if(arr[i]>arr[j]){
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
        }
        int answer=0;
        for(int i=0;i<N;++i){
            answer=Math.max(answer,dp[i]);
        }

        System.out.println(N-answer);

    }
}
