package Programmers.Lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 불량사용자 {

    public static void main(String[] args) {
        String [] user_id={"frodo","fradi","crodo","abc123","frodoc"};
        String [] baned_id={"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id,baned_id));
    }
    public static HashMap<String ,Integer> index=new HashMap<>();
    public static HashMap<String, ArrayList<String>> hm=new HashMap<>();
    public static HashSet<String> keys=new HashSet<>();
    public static int solution(String [] user_id,String [] baned_id){

        // user_id와 index
        for(int i=0;i<user_id.length;++i){
            index.put(user_id[i],i );
        }

        keySet(user_id,baned_id);

        boolean [] visited=new boolean[user_id.length];
        comb(user_id,baned_id,visited, baned_id.length-1);

        return keys.size();
    }
// HashMap 채우기
    public static void keySet(String[] user_id, String [] baned_id){
        // key : baned_id , value : ArrayList -> user_id
        for(int i=0;i<baned_id.length;++i){
            hm.put(baned_id[i],new ArrayList<>());
        }
        
        // baned_id에 해당하는 user_id arrayList에 넣기
        for(int i=0;i<baned_id.length;++i){
            String pattern=baned_id[i];
            
            ArrayList<String> tmp=new ArrayList<>();
            
            for(int j=0;j<user_id.length;++j){
                if(pattern.length()==user_id[j].length()){ // 길이가 같고
                    boolean flag=true;
                    for(int k=0;k<pattern.length();++k){
                        if(pattern.charAt(k)=='*') continue;
                        if(pattern.charAt(k)!=user_id[j].charAt(k)) { flag=false; break; } // 다르면 break해서 다시 
                    }
                    if(flag) tmp.add(user_id[j]); // 같으면 리스트에 넣어주기
                }
            }

            hm.put(pattern,tmp);
        }
    }
// comb 다시 풀어보기
    
    private static void comb(String[] user_id,String [] baned_id, boolean[] visited, int r) {
        if(r==-1){ // 다 골랐을 경우
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<visited.length;++i){
                if(visited[i]) sb.append(user_id[i]); // 체크된 것만 String에 붙이고
            }
            keys.add(sb.toString()); // Set에 추가
            return;
        }
        // r번째 baned_id에 해당하는 user_id 리스트
        ArrayList<String> list=hm.get(baned_id[r]);
        for(int i=0;i< list.size();++i){
            if(!visited[index.get(list.get(i))]){ // 방문하지 않았으면 
                visited[index.get(list.get(i))]=true; // user_id 사용
                comb(user_id,baned_id,visited, r-1);
                visited[index.get(list.get(i))]=false; // 다시 풀어주기
            }
        }
    }
}
