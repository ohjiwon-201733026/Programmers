package BaekJoon;

import java.util.Scanner;

public class B1806_부분합 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int [] arr=new int [n];

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        int start=0,end=0;
        int total=0;
        int min=Integer.MAX_VALUE;
        while (true){
            if(total>=s){
                min=Math.min(min,end-start);
                total-=arr[start++];
            }
            else if(end==n) break;
            else if(total<s){
                total+=arr[end++];
            }

        }
        if(min==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);


    }
}
