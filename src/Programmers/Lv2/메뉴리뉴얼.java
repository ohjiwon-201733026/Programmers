package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        String [] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course={2,3,4};
        String [] answer=solution(orders,course);

        for(String a:answer) System.out.println(a);
    }
    public static HashMap<String, Integer> map=new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {

        for(String order:orders) {
            String[] o = order.split("");
            Arrays.sort(o);
            for (int c : course) {
                combination(o, new boolean[o.length], 0,o.length,c);
            }
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<course.length;++i){
            int max=0;
            for(String key:map.keySet()){
                if(map.get(key)>=2 && key.length()==course[i]){
                    if(max<map.get(key)) max=map.get(key);
                }
            }

            for(String key:map.keySet()){
                if(map.get(key)>=2 && key.length()==course[i] && map.get(key)==max) list.add(key);
            }
        }
        Collections.sort(list);
        String [] answer=new String[list.size()];
        for(int i=0;i< answer.length;++i){
            answer[i]=list.get(i);
        }
        return answer;
    }

    private static void combination(String [] arr, boolean[] visited, int start, int n, int r) {
        if(r==0){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<visited.length;++i){
                if(visited[i]) sb.append(arr[i]);
            }
            String key=sb.toString();
            if(!map.containsKey(key)) map.put(key,1);
            else map.put(key,map.get(key)+1);
            return;
        }

        for(int i=start;i<n;++i){
            if(visited[i]!=true){
                visited[i]=true;
                combination(arr,visited,i+1,n,r-1);
                visited[i]=false;
            }
        }
    }

}
