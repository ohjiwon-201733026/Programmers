package BaekJoon;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715_카드정렬하기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        while(n-->0){
            int a=sc.nextInt();
            pq.add(a);
        }
        int answer=0;
        while(true){
            if(pq.size()==1) break;
           int a=pq.poll();
           int b=pq.poll();
           answer+=a+b;
           pq.add(a+b);
        }


        System.out.println(answer);
    }
}
