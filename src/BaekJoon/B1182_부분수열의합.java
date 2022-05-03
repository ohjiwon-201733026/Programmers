package BaekJoon;

import java.util.Scanner;

public class B1182_부분수열의합 {

    static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        cnt=0;

        int [] arr=new int [n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }

        backTracking(arr,0,0,n,s,false);
        System.out.println(cnt);
    }

    public static void backTracking(int [] arr, int depth, int sum, int n,int s,boolean flag){
        if(depth==n){
            if(sum==s && flag) {
                cnt++;
            }
            return;
        }

        backTracking(arr,depth+1,arr[depth]+sum,n,s,true);
        backTracking(arr,depth+1,sum,n,s,flag);

    }
}
