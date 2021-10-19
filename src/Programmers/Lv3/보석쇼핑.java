package Programmers.Lv3;

import org.junit.Test;

import java.util.*;

public class 보석쇼핑 {
    @Test
    public void test() {
        String [] gems={"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int [] answer=solution(gems);
        System.out.println(answer[0]+" "+answer[1]);
    }

    Queue<String> q=new LinkedList<>();
    HashSet<String> hs=new HashSet<>();
    HashMap<String,Integer> hm=new HashMap<>();
    int startPoint=0;
    int length=Integer.MAX_VALUE;
    public int [] solution(String [] gems){
        for (String gem : gems) {
            hs.add(gem);
        }
        int start=0;
        for(int i=0;i< gems.length;++i){
            if(!hm.containsKey(gems[i])) hm.put(gems[i],1);
            else hm.put(gems[i],hm.get(gems[i])+1);

            q.add(gems[i]);

            while(true){
                String temp=q.peek();
                if(hm.get(temp)>1){
                    hm.put(temp,hm.get(temp)-1);
                    q.poll();
                    startPoint++;
                }
                else break;
            }

            if(hm.size()==hs.size() && length>q.size()){
                length=q.size();
                start=startPoint;
            }
        }

        return new int []{start+1,start+length};
    }
}
