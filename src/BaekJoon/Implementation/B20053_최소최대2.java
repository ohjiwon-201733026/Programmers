package BaekJoon.Implementation;

import java.util.Scanner;

public class B20053_최소최대2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        while(T-->0){
            long n=sc.nextLong();
            long max=Integer.MIN_VALUE;
            long min=Integer.MAX_VALUE;
            for(int i=0;i<n;++i){
                long tmp=sc.nextLong();
                if(tmp>max) max=tmp;
                if(tmp<min) min=tmp;
            }

            System.out.println(min+" "+max);
        }
    }
}
