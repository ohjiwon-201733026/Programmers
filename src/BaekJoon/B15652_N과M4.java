package BaekJoon;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B15652_N과M4 {

    static int n,m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        int [] arr=new int [n];
        for(int i=0;i<n;++i) arr[i]=i+1;

        recur(arr,new int [m],0,0);
    }

    public static void recur(int [] arr,int [] output, int start, int depth){
        if(depth==m){
            for (int i : output) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<arr.length;++i){
            output[depth]=arr[i];
            recur(arr,output,i,depth+1);
        }
    }

}
