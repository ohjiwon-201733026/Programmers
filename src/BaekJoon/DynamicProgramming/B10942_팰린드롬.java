package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10942_팰린드롬 {

    public static int n;
    public static boolean [][] dp;
    public static int [] arr;
    public static boolean [][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        dp=new boolean [n+1][n+1];
        visit=new boolean [n+1][n+1];
        boolean [][] flag=new boolean [n+1][n+1];
        arr=new int [n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;++i){
            dp[i][i]=true;
        }

//        for(int i=1;i<n;++i){
//            if(arr[i]==arr[i+1]) dp[i][i+1]=true;
//        }
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<n;++i){
            for(int j=1;j<=n-i;++j){
                int k=j+i;
                if(arr[j]==arr[k] && dp[j+1][k-1])
                    dp[j][k]=true;
            }
        }

        for(int i=1;i<=n;++i){
            for(int j=i;j<=n;++j){
                if(arr[i]==arr[j]) flag[i][j]=true;
            }
        }


        int m=Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            if(dp[s][e]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb.toString());
    }



}
