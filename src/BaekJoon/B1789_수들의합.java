package BaekJoon;

import java.util.Scanner;

public class B1789_수들의합 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long S=sc.nextLong();

        long sum=0;
        for(long i=1;i<=4294967295L;++i){
            sum+=i;
            if(sum>S){
                System.out.println(i-1);
                return;
            }

        }
    }
}
