package Programmers.Lv3;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String [] gems={"AA", "AB", "AC", "AA", "AC"};
        int [] answer=solution(gems);
        System.out.println(answer[0]+" "+answer[1]);
    }
    public static HashMap<String , ArrayList<Integer>> hm=new HashMap<>();
    public static int [] solution(String [] gems){
        int [] answer=new int [2];
        String k="";
        for(int i=0;i< gems.length;++i){
            String gem=gems[i];
            if(hm.containsKey(gem)) hm.get(gem).add(i+1);
            else {
                if(i==0) k=gem;
                ArrayList<Integer> tmp=new ArrayList<>();
                tmp.add(i+1);
                hm.put(gem,tmp);
            }
        }
        System.out.println(k);
        for(String key: hm.keySet()){
            System.out.println(key+" :"+hm.get(key));
        }

        int minLength=Integer.MAX_VALUE;
        ArrayList<Integer> gem=hm.get(k);
        for(int i=0;i<gem.size();++i){
            int s=gem.get(i);
            int minIdx=Integer.MAX_VALUE;
            int maxIdx=0;
            for(String key: hm.keySet()){
                if(key.equals(k)) continue; // k가 포함 안됨 ,,, 1,4
                else{
                    int idx=getMinAbs(key,s);
                    if(minIdx>=idx) minIdx=idx;
                    if(maxIdx<idx) maxIdx=idx;
                }
            }

            if(minLength>maxIdx-minIdx) {
                answer[0]=minIdx; answer[1]=maxIdx;}
        }
        return answer;
    }

    public static int getMinAbs(String key, int s){
        ArrayList<Integer> tmp=hm.get(key);
        int min=Integer.MAX_VALUE;
        int minIdx=0;
        for(int i=0;i<tmp.size();++i){
            int x=Math.abs(s-tmp.get(i));
            if(min>x) { min=x; minIdx=tmp.get(i);}
        }
        return minIdx;
    }
}
