package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B15657_N과M8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] arr=new int [n];

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        Arrays.sort(arr);

        recur(arr,new int [m],0,n,m,0);
    }

    public static void recur(int [] arr, int [] output,int start,int n, int m, int depth){
        if(depth==m){
            for(int i=0;i<output.length;++i) System.out.print(output[i]+" ");
            System.out.println();
            return;
        }

        for(int i=start;i<n;++i){
                output[depth]=arr[i];
                recur(arr,output,i,n,m,depth+1);

        }


    }
}
