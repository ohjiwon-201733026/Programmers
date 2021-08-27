package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

    public static void main(String [] args){
        String msg="KAKAO";
        int [] answer=solution(msg);

    }
    public static HashMap<String,Integer>hm;
    public static int [] solution(String msg){
        hm=new HashMap<>();
        initHashMap();
        ArrayList<Integer> answer=new ArrayList<>();
        int num=27;
        for(int i=0;i<msg.length();++i){
            String s=msg.charAt(i)+"";

            while(hm.containsKey(s)){
                i++;
                if(i==msg.length()) break;
                s+=msg.charAt(i);
            }
            if(i==msg.length()) {
                answer.add(hm.get(s));
                break;
            }
            answer.add(hm.get(s.substring(0,s.length()-1)));
            hm.put(s,num);
            num++;
            i--;

        }

        int [] ans=new int [answer.size()];
        for(int i=0;i<ans.length;++i){
            ans[i]=answer.get(i);
        }

        return ans;
    }

    public static void initHashMap(){
        int i=1;
        for(char c='A';c<='Z';++c){
            hm.put(c+"",i);
            ++i;
        }
    }
}
