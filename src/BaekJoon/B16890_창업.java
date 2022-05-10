package BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B16890_창업 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] k=sc.nextLine().split("");
        String [] c=sc.nextLine().split("");


        PriorityQueue<String> K=new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        PriorityQueue<String> C=new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for(int i=0;i<k.length;++i){
            K.add(k[i]);
            C.add(c[i]);
        }

        int left=0;
        int right=k.length-1;
        String [] str=new String[k.length];
       for(int i=0;i<k.length;++i){
           if(i%2==0){ // 구사과 차례
               if(K.peek().compareTo(C.peek())>0) str[right--]=K.poll();
               else str[left++]=K.poll();
           }
           else{
               if(K.peek().compareTo(C.peek())<0) str[left++]=C.poll();
               else str[right--]=C.poll();
           }
       }

        for (String s : str) {
            System.out.print(s);
        }
    }
}
