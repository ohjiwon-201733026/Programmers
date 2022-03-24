package BaekJoon;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class B15666_N과M12 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] arr=new int [n];
        list=new LinkedHashSet<>();

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        Arrays.sort(arr);

        recur(arr,new int [m],new boolean[n],0,n,m,0);
    }
    static LinkedHashSet<String> list;
    public static void recur(int [] arr, int [] output, boolean[] visited,int start, int n, int m, int depth){
        if(depth==m){
            StringBuilder sb=new StringBuilder();
            for (int i : output) {
                sb.append(i+" ");
            }
            if(!list.contains(sb.toString())){
                System.out.println(sb.toString());
                list.add(sb.toString());
            }
            return;
        }

        for(int i=start;i<n;++i){
                output[depth]=arr[i];
                recur(arr, output,visited,i,n,m,depth+1);
            }
        }
    }
