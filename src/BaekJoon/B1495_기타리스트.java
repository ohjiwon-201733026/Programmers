package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1495_기타리스트 {

    static int n,s,m;
    static int [] v;
    static int [][] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        s=sc.nextInt();
        m=sc.nextInt();

        v=new int [n+1];
        for(int i=1;i<=n;++i) v[i]=sc.nextInt();
        dp=new int [n+1][m+1];

        nextVolume(1,s);

        boolean check=true;
        for(int i=m;i>=0;--i){
            if(dp[n][i]==1){
                System.out.println(i);
                check=false;
                break;
            }
        }

        if(check) System.out.println(-1);


    }
    public static void nextVolume(int i, int vol){
        if(i==n+1) return;
        if(vol+v[i]<=m){
            if(dp[i][vol+v[i]]==0){
                dp[i][vol+v[i]]=1;
                nextVolume(i+1,vol+v[i]);
            }
        }

        if(vol-v[i]>=0){
            if(dp[i][vol-v[i]]==0){
                dp[i][vol-v[i]]=1;
                nextVolume(i+1,vol-v[i]);
            }
        }
    }
}
