package BaekJoon;

import java.util.Scanner;

public class B11660_구간합구하기5 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int [][] arr=new int [n+1][n+1];
        int [][] sum=new int [n+1][n+1];

        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                arr[i][j]=sc.nextInt();
            }
        }
        sum[1][1]=arr[1][1];
        for(int i=2;i<=n;++i) {
            sum[i][1] = sum[i - 1][1] + arr[i][1];
            sum[1][i] = sum[1][i - 1] + arr[1][i];
        }


        for(int i=2;i<=n;++i){
            for(int j=2;j<=n;++j){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]+arr[i][j]-sum[i-1][j-1];
            }
        }
        StringBuilder sb=new StringBuilder();
        while (m-->0){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();

            int num=sum[x2][y2]+sum[x1-1][y1-1]-sum[x2][y1-1]-sum[x1-1][y2];
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());

    }


}
