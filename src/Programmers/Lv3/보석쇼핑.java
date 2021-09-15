package Programmers.Lv3;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String [] gems={"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int [] answer=solution(gems);
        System.out.println(answer[0]+" "+answer[1]);
    }
    static Queue<String> q=new LinkedList<>();
    static HashSet<String> hs=new HashSet<>();
    static HashMap<String,Integer> hm=new HashMap<>();
    static int startPoint=0;
    static int length=Integer.MAX_VALUE;
    public static int [] solution(String [] gems){
        int [] answer=new int [2];
        for(String g:gems) hs.add(g);
        int start=0;
        for(int i=0;i<gems.length;++i){
            // 배열 돌면서 hashMap에 없다면 값을 추가해주고 있다면 개수를 하나 추가해준다.
            if(!hm.containsKey(gems[i])) hm.put(gems[i],1);
            else hm.put(gems[i],hm.get(gems[i])+1);

            // 큐에 보석을 담아준다.
            q.add(gems[i]);

            // 큐에 첫번째 보석의 개수가 1개를 초과한다면 startPoint를 갱신해주고 q에서 빼준다
            while(true){
                String temp=q.peek();
                if (hm.get(temp)>1){
                    hm.put(temp,hm.get(temp)-1);
                    q.poll();
                    startPoint++;
                }
                else break;
            }
            // 만약 현재 큐에 있는 보석이 모든 보석을 포함한다고(hm크기와 hs의 크가가 같다면
            // 새로 구한 구간이 현재 구간의 길이보다 작다면 최종 시작 포인트 값인 start 값 갱신해준다.
            if(hm.size()==hs.size() && length>q.size()){
                length=q.size();
                start=startPoint;
            }

        }


        return new int []{start+1,start+length};
    }
}
