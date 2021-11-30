package BaekJoon;

import java.util.HashSet;
import java.util.Scanner;

public class B10815_숫자카드 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set=new HashSet<>();
        int N=sc.nextInt();
        while(N-->0){
            set.add(sc.nextInt());
        }
        StringBuilder sb=new StringBuilder();
        int M=sc.nextInt();
        while(M-->0){
            int n=sc.nextInt();
            if(set.contains(n)) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb.toString());

    }
}
