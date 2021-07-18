package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class 튜플 {
    public static void main(String[] args) {
        String s="{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int [] answer=solution(s);
        for(int n:answer) System.out.println(n);
    }
    public static class Tuple implements Comparable<Tuple>{
        ArrayList<String> arr;
        int length;

        public Tuple(String [] arr){
            this.arr=new ArrayList<>();
            for(String s: arr) this.arr.add(s);
            length=arr.length;
        }


        @Override
        public int compareTo(Tuple o) {
            return this.length-o.length;
        }
    }
    private static int[] solution(String s) {
        int[] answer = {};
        String [] tup=s.split("[{}]");
        ArrayList<Tuple> tuples=new ArrayList<>();
        for(String a: tup) {
            if(a.equals(",")|| a.length()==0) continue;
            else{
                String [] tmp=a.split(",");
                tuples.add(new Tuple(tmp));
            }
        }
        Collections.sort(tuples);
        ArrayList<String> ans=new ArrayList<>();

        for(Tuple t:tuples){
            if(t.arr.size()==0) continue;
            for(String h:t.arr){
                if(ans.contains(h)) continue;
                else ans.add(h);
            }
        }

        answer=new int [ans.size()];
        for(int i=0;i<ans.size();++i) answer[i] = Integer.parseInt(ans.get(i));


        return answer;
    }
}
