package programmers2.level2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 메뉴리뉴얼 {

    @Test
    public void test(){
        String [] answer={"ACD", "AD", "ADE", "CD", "XYZ"};
        String [] result=solution(new String []{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},new int []{2,3,5});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }
    public HashMap<String,Integer> map;
    public String [] solution(String [] orders, int [] course){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<course.length;++i){
            int num=course[i];
            map=new HashMap<>();
            for (String order : orders) {
                char [] arr=order.toCharArray();
                Arrays.sort(arr);
                boolean [] visited=new boolean[arr.length];

                comb(arr,visited,0,arr.length,num);

            }
            int max=0;
            for (String s : map.keySet()) {
                if(map.get(s)>max) max=map.get(s);
            }

            for (String s : map.keySet()) {
                if(map.get(s)==max && map.get(s)>=2) list.add(s);
            }
        }
        Collections.sort(list);
        String [] answer=new String[list.size()];
        for(int i=0;i<list.size();++i) answer[i]=list.get(i);
        return answer;
    }
    private void comb(char[] arr, boolean[] visited, int start, int n, int r) {
        if(r==0){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<visited.length;++i){
                if(visited[i]) {
                    sb.append(arr[i]);
                }
            }

            if(map.containsKey(sb.toString())) map.put(sb.toString(),map.get(sb.toString())+1);
            else map.put(sb.toString(),1);
            return;
        }

        for(int i=start;i<n;++i){
            if(visited[i]!=true){
                visited[i]=true;
                comb(arr,visited,i+1,n,r-1);
                visited[i]=false;
            }
        }
    }
}
