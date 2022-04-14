package BaekJoon;


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
        dp=new int [n+1][m+1];

        for(int i=1;i<=n;++i) v[i]=sc.nextInt();

        nextVol(s,1);

        boolean flag=true;
        for(int i=m;i>=0;i--){
            if(dp[n][i]==1){
                System.out.println(i);
                flag=false;
                break;
            }
        }

        if(flag) System.out.println(-1);
    }

    public static void nextVol(int vol, int idx){
        if(idx==n+1){
            return;
        }

        if(vol-v[idx]>=0){
            if(dp[idx][vol-v[idx]]==0){
                dp[idx][vol-v[idx]]=1;
                nextVol(vol-v[idx],idx+1);
            }
        }

        if(vol+v[idx]<=m){
            if(dp[idx][vol+v[idx]]==0){
                dp[idx][vol+v[idx]]=1;
                nextVol(vol+v[idx],idx+1);
            }
        }
    }
}
