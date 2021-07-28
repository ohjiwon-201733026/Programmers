package Programmers.Lv2;

import java.util.Arrays;
import java.util.HashMap;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        String [] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course={2,3,4};
        String [] answer=solution(orders,course);

        for(String a:answer) System.out.println(a);
    }
    public static String [] o;
    public static boolean [] visit;
    public static HashMap<String,Integer> hm=new HashMap<>();
    public static String [] solution(String [] orders, int [] course){

        for(int i=0;i<course.length;++i){
            for(String order : orders){
                o=order.split("");
                Arrays.sort(o);
                visit=new boolean[o.length];
                combination(o.length,course[i],0,0);
            }
        }



        StringBuilder sb=new StringBuilder();
        for(int i=0;i<course.length;++i){
            int max=0;
            for(String key:hm.keySet()){
                if(key.length()==course[i] && hm.get(key)>=2) {
                    if (max < hm.get(key)) max = hm.get(key);
                }
            }

            for(String key:hm.keySet()){
                if(key.length()==course[i] && max==hm.get(key) && hm.get(key)>=2) sb.append(key+",");
            }
        }

        String [] answer=sb.toString().split(",");
        Arrays.sort(answer);
        return answer;
    }

    public static void combination(int n, int r, int depth,int start){
        if(depth==r){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<visit.length;++i){
                if(visit[i]) sb.append(o[i]);
            }
            String key=sb.toString();
            if(!hm.containsKey(key)) hm.put(key,1);
            else hm.put(key,hm.get(key)+1);
            return;
        }

        for(int i=start;i<n;++i){
            if(visit[i]==false){
                visit[i]=true;
                combination(n,r,depth+1,i);
                visit[i]=false;
            }
        }
    }
}
