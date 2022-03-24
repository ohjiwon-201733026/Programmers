package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B15650_N과M2 {
    static ArrayList<String> list;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        list=new ArrayList<>();

        int [] arr=new int [n];
        for(int i=0;i<n;++i){
            arr[i]=i+1;
        }

        recur(arr,new boolean[n],n,m);

        for (String s : list) {
            System.out.println(s);
        }
    }

    static void recur(int [] arr,boolean [] visited,int n, int r){
        if(r==0){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;++i){
                if(visited[i]){
                    sb.append(arr[i]+" ");
                }
            }
            if(!list.contains(sb.toString())) list.add(sb.toString());
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]){
                visited[i]=true;
                recur(arr,visited,n,r-1);
                visited[i]=false;
            }
        }
    }
}
