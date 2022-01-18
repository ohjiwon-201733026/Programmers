package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 보석쇼핑 {

    @Test
    public void test(){
        int [] ans=solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        Assertions.assertEquals(ans[0],3);
        Assertions.assertEquals(ans[1],7);

        ans=solution(new String []{"AA", "AB", "AC", "AA", "AC"});
        Assertions.assertEquals(ans[0],1);
        Assertions.assertEquals(ans[1],3);

        ans=solution(new String[]{"XYZ", "XYZ", "XYZ"});
        Assertions.assertEquals(ans[0],1);
        Assertions.assertEquals(ans[1],1);

        ans=solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        Assertions.assertEquals(ans[0],1);
        Assertions.assertEquals(ans[1],5);
    }

    public int [] solution(String [] gems){
        Queue<String> q=new LinkedList<>();
        HashSet<String> hs=new HashSet<>();
        HashMap<String,Integer> hm=new HashMap<>();
        int startPoint=0;
        int length=Integer.MAX_VALUE;

        int [] answer=new int[2];
        for (String gem : gems) hs.add(gem);

        int start=0;

        for(int i=0;i<gems.length;++i){
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

            if(hm.size()==hs.size() && length > q.size()){
                length=q.size();
                start=startPoint;
            }
        }

        return new int [] {start+1,start+length};
    }
}