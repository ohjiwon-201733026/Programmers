package BaekJoon.Strings;

import java.util.*;

public class B20437_문자열게임2 {

    public static List<Integer>[] alpha;
    public static LinkedList<Integer> list;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(T-->0){
            String s=sc.next();
            int K=sc.nextInt();

            int step3=game(s,K,3);
            sb.append(step3);
            if(step3!=-1){
                int step4=game(s,K,4);
                sb.append(" "+step4);
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());

    }

    private static int game(String s, int k, int step) {
        alpha=new ArrayList[26];
        for(int i=0;i<26;++i){
            alpha[i]=new ArrayList<>();
        }

        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            alpha[c-'a'].add(i);
        }
        list=new LinkedList<>();

        for(int i=0;i<26;++i){
            int size=alpha[i].size();
            if(size<k) continue;

            for(int idx=0;idx<size-k+1;++idx){
                list.offerLast(alpha[i].get(idx+k-1)-alpha[i].get(idx)+1);
            }
        }

        if(list.size()==0) return -1;
        int min=Integer.MAX_VALUE;
        int max=0;

        while(!list.isEmpty()){
            int val=list.poll();

            min=Math.min(val,min);
            max=Math.max(val,max);
        }

        return step==3?min:max;
    }
}

