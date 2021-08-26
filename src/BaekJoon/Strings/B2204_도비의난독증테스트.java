package BaekJoon.Strings;

import java.util.*;

public class B2204_도비의난독증테스트 {
    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);


        while(true){
            int T=sc.nextInt();
            if(T==0) System.exit(0);
            List<Word> list=new ArrayList<>();
            while(T-->0){
                String s=sc.next();
                list.add(new Word(s,s.toLowerCase()));
            }

            Collections.sort(list);
            System.out.println(list.get(0).w);
        }
    }

    public static class Word implements Comparable<Word>{
        String w;
        String lower;

        public Word(String w, String lower) {
            this.w = w;
            this.lower = lower;
        }

        @Override
        public int compareTo(Word o) {
            return this.lower.compareTo(o.lower);
        }
    }
}
