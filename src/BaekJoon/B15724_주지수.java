package BaekJoon;

import java.util.Scanner;

public class B15724_주지수 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] arr=new int [n+1][m+1];
        int [][] sum=new int [n+1][m+1];

        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i][j];
            }
        }

        int k=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (k-->0){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int num=sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
            System.out.println(num);
        }

    }
}
