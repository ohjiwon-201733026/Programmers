package BaekJoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B11066_파일합치기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0) {
            int K = sc.nextInt();
            int [] arr=new int [K];
            for(int i=0;i<K;++i){
                arr[i]=sc.nextInt();
            }
            System.out.println(solution(arr));
        }
    }

    public static int solution(int [] file){
        int [][] dp=new int [file.length][file.length];
        int [] sum=new int [file.length];
        sum[0]=file[0];

        for(int i=1;i<sum.length;++i){
            sum[i]=sum[i-1]+file[i];
        }

        for(int i=0;i<file.length-1;++i){
            dp[i][i+1]=file[i]+file[i+1];
        }

        for(int j=2;j<file.length;++j){
            for(int i=0;i+j<file.length;++i){
                for(int k=i;k<i+j;++k){
                    if(dp[i][i+j]==0){
                        dp[i][i+j]=dp[i][k]+dp[k+1][i+j]+sumDist(sum,i,i+j);
                    }else{
                        dp[i][i+j]=Math.min(dp[i][i+j],dp[i][k]+dp[k+1][i+j]+sumDist(sum,i,i+j));
                    }
                }
            }
        }
        return dp[0][file.length-1];
    }

    static int sumDist(int [] sum, int start, int end){
        if(start==0){
            return sum[end];
        }
        else{
            return sum[end]-sum[start-1];
        }
    }
}
