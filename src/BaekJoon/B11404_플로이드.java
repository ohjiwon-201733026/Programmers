package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11404_플로이드 {
    static int INF=987654321;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int [][] arr=new int [n+1][n+1];

        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                arr[i][j]=INF;
                if(i==j) arr[i][j]=0;
            }
        }

        while(m-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int w=sc.nextInt();
            arr[a][b]=Math.min(arr[a][b],w);
        }


        for(int k=1;k<=n;++k){
            for(int i=1;i<=n;++i){
                for(int j=1;j<=n;++j){
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 갈 수 없는 곳은 0으로 초기화
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }

                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}