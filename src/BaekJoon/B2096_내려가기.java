package BaekJoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2096_내려가기 {

    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int [] maxDp=new int [3];
       int [] minDp=new int [3];

       for(int i=0;i<n;++i){
           int a=sc.nextInt();
           int b=sc.nextInt();
           int c=sc.nextInt();

           if(i==0){
               maxDp[0]=a; minDp[0]=a;
               maxDp[1]=b; minDp[1]=b;
               maxDp[2]=c; minDp[2]=c;
               continue;
           }

           int maxLeft=maxDp[0],maxRight=maxDp[2];
           int minLeft=minDp[0],minRight=minDp[2];

           // 0
           maxDp[0]=Math.max(maxDp[0],maxDp[1])+a;
           minDp[0]=Math.min(minDp[0],minDp[1])+a;

           // 2
           maxDp[2]=Math.max(maxDp[1],maxDp[2])+c;
           minDp[2]=Math.min(minDp[1],minDp[2])+c;

           // 1
           maxDp[1]=Math.max(maxLeft,Math.max(maxDp[1],maxRight))+b;
           minDp[1]=Math.min(minLeft,Math.min(minDp[1],minRight))+b;

       }


        System.out.print(Math.max(maxDp[0],Math.max(maxDp[1],maxDp[2]))+" ");
        System.out.println(Math.min(minDp[0],Math.min(minDp[1],minDp[2])));
    }
}
