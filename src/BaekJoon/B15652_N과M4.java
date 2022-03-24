package BaekJoon;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B15652_N과M4 {

    static int n,M;
    static int [] arr;
//    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        M=sc.nextInt();
        arr=new int [n];
        for(int i=0;i<n;++i){
         arr[i]=i+1;
        }
        int [] output=new int [M];
        perm(arr,output,0,n,M,0);
    }
    private static void perm(int [] arr,int[] output, int start, int n, int r, int cnt) {
        if(cnt==r){
            for(int i=0;i<cnt;++i) System.out.print(output[i]+" ");
            System.out.println();
            return;
        }

        for(int i=start;i<n;++i){ // 자신아니면 자신보다 큰 수 1 1, 1 2, 1 3, ...
            output[cnt]=arr[i];
            perm(arr,output,i,n,r,cnt+1);
        }
    }
}
