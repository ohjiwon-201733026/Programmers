package BaekJoon.Strings;

import java.util.Scanner;

public class B20944_팰린드롬척화비 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int n=(int)Math.floor(N/2);
        StringBuilder sb=new StringBuilder();
        if(N%2==0){
            for(int i=0;i<N;++i) sb.append("a");
        }else{
            for(int i=0;i<n;++i) sb.append("s");
            sb.append("t");
            for(int i=0;i<n;++i) sb.append("s");
        }

        System.out.println(sb.toString());
    }
}
