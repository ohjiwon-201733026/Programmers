package BaekJoon;

import java.util.Scanner;

public class B1806_부분합 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int [] arr=new int [n+1];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int min=Integer.MAX_VALUE;

        int start=0;
        int end=0;
        int total=0;
        while (start<=n && end<=n){
            if(total>=s && min>end-start) min=end-start;

            if(total<s) total+=arr[end++];
            else total-=arr[start++];
        }

        if(min==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}
