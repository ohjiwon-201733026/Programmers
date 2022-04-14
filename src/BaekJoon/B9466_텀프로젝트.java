package BaekJoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B9466_텀프로젝트 {
    static int [] arr;
    static boolean[] visit,done;
    static int cnt,n;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        while (t-->0){
            n=sc.nextInt();
            arr=new int [n+1];
            visit=new boolean[n+1];
            done=new boolean[n+1];

            for(int i=1;i<=n;++i) arr[i]=sc.nextInt();

            cnt=0;
            for(int i=1;i<=n;++i) dfs(i);

            System.out.println(n-cnt);
        }

    }

    public static void dfs(int pos){
        visit[pos]=true;
        int next=arr[pos];
        if(!visit[next]) dfs(next);
        else{
            if(!done[next]){
                cnt++;
                while (next!=pos){
                    cnt++;
                    next=arr[next];
                }
            }
        }

        done[pos]=true;
    }
}
