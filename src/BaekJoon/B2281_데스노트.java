package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2281_데스노트 {
    static int n,m;
    static int [][] grid;
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int [n];
        grid=new int [1000][1002];

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        for(int i=0;i<n;++i) Arrays.fill(grid[i],-1);

        System.out.println(recur(1,arr[0]+1));

    }

    public static int recur(int i, int cnt){
        if(i==n) return 0;
        if(grid[i][cnt]!=-1) return grid[i][cnt];

        int ans=grid[i][cnt];
        // 1. 다음 칸에 넣을 때
        int left= m-cnt+1;
        ans=(left*left)+recur(i+1,arr[i]+1);

        // 2. 현재 칸에 넣을 때
        if(cnt+arr[i]<=m){
            ans=Math.min(ans,recur(i+1,cnt+arr[i]+1));
        }

        return grid[i][cnt]=ans;
    }


}
