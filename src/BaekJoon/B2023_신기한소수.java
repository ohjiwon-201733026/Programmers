package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2023_신기한소수 {

    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        list=new ArrayList<>();

        for(int i=1;i<=9;++i){
            if(isPrime(i)) recur(i,1,n);
        }

        Collections.sort(list);
        for (Integer a : list) {
            System.out.println(a);
        }
    }

    static void recur(int num, int depth, int n){
        if(depth==n){
            list.add(num);
            return;
        }

        for(int i=0;i<=9;++i){
            int next=Integer.parseInt(String.valueOf(num)+i);
            if(isPrime(next)){
                recur(next,depth+1,n);
            }
        }
    }

    static boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=2;i<=Math.sqrt(n);++i){
            if(n%i==0) return false;
        }

        return true;
    }
}
