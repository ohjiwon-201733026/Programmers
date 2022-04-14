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
            if(isPrime(i))
            backTracking(i,1,n);
        }
        Collections.sort(list);

        for (Integer num : list) {
            System.out.println(num);
        }

    }

    public static void backTracking(int num, int depth, int n){
        if(depth==n){
            if(isPrime(num)){
                list.add(num);
            }
            return;
        }

        for(int i=0;i<=9;++i){
            String s=String.valueOf(num)+i;
            if (isPrime(Integer.parseInt(s))){
                backTracking(Integer.parseInt(s),depth+1,n);
            }
        }
    }

    static boolean isPrime(int n){
        if(n==1 || n==0) return false;

        for(int i=2;i<=Math.sqrt(n);++i){
            if(n%i==0) return false;
        }

        return true;
    }
}
