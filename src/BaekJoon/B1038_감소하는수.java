package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1038_감소하는수 {
    static ArrayList<Long> list;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        list=new ArrayList<>();
        int n=sc.nextInt();

        if(n==0){
            System.out.println(0);
            return;
        }
        else if(n>1022) {
            System.out.println(-1);
            return;
        }
        else{

            for(int i=0;i<10;++i){
                recur(i,1);
            }

            Collections.sort(list);
            System.out.println(list.get(n));
            return;
        }
    }

    public static void recur(long num, int idx){
        if(idx>10) return;

        list.add(num);

        for(int i=0;i<num%10;++i){
            recur((10*num)+i,i+1);
        }
    }
}
