package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B15654_N과M5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] arr=new int [n];

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        Arrays.sort(arr);

        recur(arr,new int [m],new boolean[n],n,m,0);
    }

    public static void recur(int [] arr, int [] output,boolean[] visited,int n, int m, int depth){
        if(depth==m){
            for (int i : output) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                recur(arr,output,visited,n,m,depth+1);
                visited[i]=false;
            }

        }


    }
}
