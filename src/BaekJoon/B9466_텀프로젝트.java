package BaekJoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B9466_텀프로젝트 {
    static int [] arr;
    static boolean[] visit,done;
    static int cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),n;

        while(t-->0){
            n=sc.nextInt();
            cnt=0;
            arr=new int [n+1]; visit=new boolean[n+1];done=new boolean[n+1];

            for(int i=1;i<=n;++i) arr[i]=sc.nextInt();
            for(int i=1;i<=n;++i) if(!done[i]) dfs(i);
            System.out.println(n-cnt);

        }
    }
    private static void dfs(int v){
        if(visit[v]) {
            done[v]=true;
            cnt++;
        }
        else visit[v]=true;

        if(!done[arr[v]]) dfs(arr[v]);
        visit[v]=false; done[v]=true;
    }
}
