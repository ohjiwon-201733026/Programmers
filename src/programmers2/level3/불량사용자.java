package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 불량사용자 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String []{"fr*d*", "abc1**"}));
        Assertions.assertEquals(2,solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String []{"*rodo", "*rodo", "******"}));
        Assertions.assertEquals(3,solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String []{"fr*d*", "*rodo", "******", "******"}));
    }
    static HashMap<String, Integer> userIndex=new HashMap<>();
    static HashMap<String, ArrayList<String>> map=new HashMap<>();
    static HashSet<String> set=new HashSet<>();
    public int solution(String [] user_id, String [] banned_id){
        for(int i=0;i<user_id.length;++i) userIndex.put(user_id[i],i);

        keySet(user_id,banned_id);

        boolean [] visited=new boolean[user_id.length];

        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }

        comb(user_id, banned_id,visited,banned_id.length-1);

        return set.size();
    }

    private void keySet(String [] user_id, String [] banned_id){
        for(int i=0;i<banned_id.length;++i) map.put(banned_id[i],new ArrayList<>());

        for(int i=0;i<banned_id.length;++i){
            ArrayList<String> tmp=new ArrayList<>();
            String pattern=banned_id[i];
            for(int j=0;j<user_id.length;++j){
                String user=user_id[j];
                boolean flag=true;
                if(pattern.length()==user.length()){
                    for(int k=0;k<pattern.length();++k){
                        if(pattern.charAt(k)=='*') continue;
                        if(pattern.charAt(k)!=user.charAt(k)){
                            flag=false;
                            break;
                        }
                    }
                    if (flag) tmp.add(user);
                }

            }

            map.put(pattern,tmp);
        }
    }

    private void comb(String [] user_id,String [] banned_id,boolean [] visited, int r){
        if(r==-1){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<visited.length;++i){
                if(visited[i]) sb.append(user_id[i]);
            }

            set.add(sb.toString());
            return;
        }

        ArrayList<String> list=map.get(banned_id[r]);
        for(int i=0;i<list.size();++i){
            if(!visited[userIndex.get(list.get(i))]){
                visited[userIndex.get(list.get(i))]=true;
                comb(user_id,banned_id,visited,r-1);
                visited[userIndex.get(list.get(i))]=false;
            }
        }
    }
}
