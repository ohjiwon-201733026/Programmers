package BaekJoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2096_내려가기 {

    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int [][] maxDp=new int [n][3];
       int [][] minDp=new int [n][3];
       int [][] arr=new int [n][3];

        for(int i=0;i<n;++i){
            for(int j=0;j<3;++j){
                arr[i][j]=sc.nextInt();
            }
        }

       for(int i=0;i<3;++i){
           maxDp[0][i]=minDp[0][i]=arr[0][i];
       }


       for(int i=1;i<n;++i){
           maxDp[i][0]=Math.max(maxDp[i-1][0],maxDp[i-1][1])+arr[i][0];
           minDp[i][0]=Math.min(minDp[i-1][0],minDp[i-1][1])+arr[i][0];

           maxDp[i][1]=Math.max(maxDp[i-1][0],Math.max(maxDp[i-1][1],maxDp[i-1][2]))+arr[i][1];
           minDp[i][1]=Math.min(minDp[i-1][0],Math.min(minDp[i-1][1],minDp[i-1][2]))+arr[i][1];

           maxDp[i][2]=Math.max(maxDp[i-1][1],maxDp[i-1][2])+arr[i][2];
           minDp[i][2]=Math.min(minDp[i-1][1],minDp[i-1][2])+arr[i][2];
       }

        System.out.print(Math.max(maxDp[n-1][0],Math.max(maxDp[n-1][1],maxDp[n-1][2]))+" ");
        System.out.println(Math.min(minDp[n-1][0],Math.min(minDp[n-1][1],minDp[n-1][2])));
    }
}
