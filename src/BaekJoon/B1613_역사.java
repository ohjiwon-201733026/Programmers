package BaekJoon;

import java.util.Scanner;

public class B1613_역사 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] arr=new int [n+1][n+1];

        while(m-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();

            arr[a][b]=-1;
            arr[b][a]=1;
        }

        for(int k=1;k<=n;++k){
            for(int i=1;i<=n;++i){
                for(int j=1;j<=n;++j){
                        if(arr[i][k]==1 && arr[k][j]==1) arr[i][j]=1;
                        if(arr[i][k]==-1 && arr[k][j]==-1) arr[i][j]=-1;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int s=sc.nextInt();
        while(s-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            sb.append(arr[a][b]+"\n");
        }

        System.out.println(sb.toString());
    }
}
