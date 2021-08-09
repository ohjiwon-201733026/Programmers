package Programmers.Lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 불량사용자 {

    public static void main(String[] args) {
        String [] user_id={"frodo","fradi","crodo","abc123","frodoc"};
        String [] baned_id={"fr*d*", "abc1**"};
        System.out.println(solution(user_id,baned_id));
    }
    public static HashMap<String ,Integer> index=new HashMap<>();
    public static HashMap<String, ArrayList<String>> hm=new HashMap<>();
    public static ArrayList<String> keys=new ArrayList<>();
    public static int solution(String [] user_id,String [] baned_id){

        for(int i=0;i<user_id.length;++i){
            index.put(user_id[i],i );
        }
        keySet(user_id,baned_id);


        boolean [] visited=new boolean[user_id.length];
        comb(user_id,baned_id,visited,0, baned_id.length-1);


        return keys.size();
    }

    public static void keySet(String[] user_id, String [] baned_id){
        for(int i=0;i<baned_id.length;++i){
            hm.put(baned_id[i],new ArrayList<>());
        }

        for(int i=0;i<baned_id.length;++i){
            String pattern=baned_id[i];
            ArrayList<String> tmp=new ArrayList<>();
            for(int j=0;j<user_id.length;++j){
                if(pattern.length()==user_id[j].length()){
                    boolean flag=true;
                    for(int k=0;k<pattern.length();++k){
                        if(pattern.charAt(k)=='*') continue;
                        if(pattern.charAt(k)!=user_id[j].charAt(k)) { flag=false; break; }
                    }
                    if(flag) tmp.add(user_id[j]);
                }
            }

            hm.put(pattern,tmp);
        }
    }
// comb 다시 풀어보기
    private static void comb(String[] user_id,String [] baned_id, boolean[] visited, int start, int r) {
        if(r==-1){
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<visited.length;++i){
                if(visited[i]) list.add(user_id[i]+" ");
            }
            StringBuilder sb=new StringBuilder();
            if(list.size()==baned_id.length) {
                Collections.sort(list);
                for(int i=0;i<list.size();++i) sb.append(list.get(i));
                if(!keys.contains(sb.toString())) keys.add(sb.toString());
            }
            return;
        }

        ArrayList<String> list=hm.get(baned_id[r]);
        for(int i=0;i<list.size();++i){
            if(!visited[i]) {
                String userId = list.get(i);
                int idx = index.get(userId);
                visited[idx] = true;
                comb(user_id, baned_id,visited, start + 1, r - 1);
                visited[idx] = false;
            }
        }
    }
}
