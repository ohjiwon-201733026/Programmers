package BaekJoon.Implementation;

import java.util.Scanner;

public class B5597_과제안내신분 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean [] num=new boolean [31];
        for(int i=0;i<28;++i){
            int n=sc.nextInt();
            num[n]=true;
        }

        for(int i=1;i<=30;++i){
            if(!num[i]) System.out.println(i);
        }
    }
}
